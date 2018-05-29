#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
	int x;
	int pid;
	printf("Enter an integer: ");
	scanf("%d", &x);
	
	pid = fork();
	
	if (pid < 0) {
		printf("ERROR: Fork failed. \n");
		exit(-1);	
	}
	
	else if (pid == 0) {
		printf("%d \n",x);
		while (x != 1) {
			if((x % 2) != 0) {			
				x = (x * 3) + 1;
			}
			else {
				x = (x / 2);
			}
			printf("%d \n",x);		
		}	
	}
	
	else {
		wait(&pid);
	}
	
	return 0;
}
