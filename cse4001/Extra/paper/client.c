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
	struct sockaddr_in serv_addr;
	int y = socket(AF_INET, SOCK_STREAM, 0);
	char buffer[256];
	memset(&serv_addr, 0, sizeof(struct sockaddr_in));
	int portno = 5575;
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(portno);
	int a = connect(y, (struct sockaddr *) &serv_addr,
        sizeof(serv_addr));
    if (a < 0) {
        printf("ERROR on connecting. \n");
		exit(-1);
	}
    read(y, buffer, 255);
	printf("%s \n", buffer);
	return 0;
}
