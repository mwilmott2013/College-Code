#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h> 
#include <sys/shm.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

#define SHMSZ     27

int main(void) {
	int x;
	int pid;
	printf("Enter an integer: ");
	scanf("%d", &x);
	
    int shmid;     
	key_t key;
    int *shm, *s;     
	/* We'll name our shared memory segment "2013".*/     
	 key = 2013;
    /* Create the segment.*/
    if ((shmid = shmget(key, SHMSZ, IPC_CREAT | 0666)) < 0) {	
		perror("shmget");
        exit(1);
	}
    /* attach the segment to our data space.*/   
    if ((shm = shmat(shmid, NULL, 0)) == (char *) -1) {
        perror("shmat");        
		exit(1);
    }
	
	pid = fork();
	
	if (pid < 0) {
		printf("ERROR: Fork failed. \n");
		exit(-1);	
	}
	
	else if (pid == 0) {

		while (x != 1) {
			if ((x % 2) != 0) {
				x = (x * 3) + 1;
				*++shm = x;
			}
			else {
				x = (x / 2);
				*++shm = x;
			}
		}
		*shm++ = 1;
		*shm++ = NULL;
	}
	
	else {
		for (;*shm != NULL; shm++) {
			printf("%d \n",*shm);	
			wait(&pid);
		}
	}
	
	return 0;
}
