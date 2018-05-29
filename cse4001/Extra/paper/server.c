#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <netdb.h>
#include <errno.h>


int main(void) {
	
	struct sockaddr_in my_addr, cli_addr;
	int y = socket(AF_INET, SOCK_STREAM, 0);
	memset(&my_addr, 0, sizeof(struct sockaddr_in));
	int portno = 5575;
    my_addr.sin_family = AF_INET;
    my_addr.sin_addr.s_addr = INADDR_ANY;
    my_addr.sin_port = htons(portno);
	int c = bind(y, (struct sockaddr *) &my_addr, sizeof(my_addr));
    if (c < 0) {
        printf("ERROR on binding. \n");
		exit(-1);
		}
    int t = listen(y,5);
	while(1){
		int r = sizeof(cli_addr);
		int z = accept(y, (struct sockaddr *) &cli_addr, &r);
		if (z < 0) {
			printf("ERROR: Failed to accept. \n");
			exit(-1);
		}
		write(z, "Blowing from the west, Leaves that fall from Teldrassil, Gather in the East.", 75);
		close(z);
	}
	close(y);
	return 0;
}
