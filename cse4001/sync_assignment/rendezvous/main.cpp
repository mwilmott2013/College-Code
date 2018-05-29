#include <unistd.h>     /* Symbolic Constants */
#include <sys/types.h>  /* Primitive System Data Types */
#include <errno.h>      /* Errors */
#include <stdio.h>      /* Input/Output */
#include <stdlib.h>     /* General Utilities */
#include <pthread.h>    /* POSIX Threads */
#include <string.h>     /* String handling */
#include <semaphore.h>  /* Semaphore */
#include <iostream>
using namespace std;

class Semaphore {
public:
    // Constructor
    Semaphore(int initialValue)
    {
        sem_init(&mSemaphore, 0, initialValue);
    }
    // Destructor
    ~Semaphore()
    {
        sem_destroy(&mSemaphore); /* destroy semaphore */
    }
    
    // wait
    void wait()
    {
        sem_wait(&mSemaphore);
    }
    // signal
    void signal()
    {
        sem_post(&mSemaphore);
    }
    
    
private:
    sem_t mSemaphore;
};


Semaphore aArrived(0);
Semaphore bArrived(0);



void *RendevousA (void*)
{

    while( 1 )
    {
       // sleep(3); // Slow the thread down a bit so we can see what is going on
        printf("Statement A1\n");
        aArrived.signal();
		bArrived.wait();
		printf("Statement A2\n");
    }

}

void *RendevousB (void*)
{

    while( 1 )
    {
       // sleep(3); // Slow the thread down a bit so we can see what is going on
        printf("Statement B1\n");
        bArrived.signal();
		aArrived.wait();
		printf("Statement B2\n");
    }

}

int main(int argc, char **argv )
{
    pthread_t aThread;
    pthread_t bThread;

    // Create a thread 
    int alpha = pthread_create ( &aThread, NULL, RendevousA, (void*)NULL);
        if (alpha) {
            printf("ERROR creating thread # %d; \
                    return code from pthread_create() is %d\n", alpha);
            exit(-1);
        }

    // Create b thread 
    int beta = pthread_create ( &bThread, NULL, RendevousB, (void*)NULL );
        if (beta) {
            printf("ERROR creating consumer thread # %d; \
                    return code from pthread_create() is %d\n", beta);
            exit(-1);
        }

    printf("Main: program completed. Exiting.\n");


    // To allow other threads to continue execution, the main thread 
    // should terminate by calling pthread_exit() rather than exit(3). 
    pthread_exit(NULL); 


} /* main() */
