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

const int numReaders = 4;
const int numWriters = 2;


Semaphore empty(1);
Semaphore turnstile(1);
Semaphore mutex(1);
int readers = 0;



void *Writer ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		turnstile.wait();
			empty.wait();
				printf("A writer is manipulating.");
			empty.signal();
		turnstile.signal();
    }

}

void *Reader ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		turnstile.wait();
		turnstile.signal();
		
		mutex.wait();
			readers++;
			if (readers == 1){
				empty.wait();
			}
		mutex.signal();
		
		printf("A reader is reading.");
		
		mutex.wait();
			readers--;
			if (readers == 0){
				empty.signal();
			}
		mutex.signal();
    }

}

int main(int argc, char **argv )
{
    pthread_t writerThread[ numWriters ];
    pthread_t readerThread[ numReaders ];

    // Create the writers 
    for( long w = 0; w < numWriters; w++ )
    {
        int a = pthread_create ( &writerThread[ w ], NULL, 
                                  Writer, (void *) (w+1) );
        if (a) {
            printf("ERROR creating writer thread # %d; \
                    return code from pthread_create() is %d\n", w, a);
            exit(-1);
        }
    }

    // Create the readers 
    for( long r = 0; r < numReaders; r++ )
    {
        int b = pthread_create ( &readerThread[ r ], NULL, 
                                  Reader, (void *) (r+1) );
        if (b) {
            printf("ERROR creating reader thread # %d; \
                    return code from pthread_create() is %d\n", r, b);
            exit(-1);
        }
    }

    printf("Main: program completed. Exiting.\n");


    // To allow other threads to continue execution, the main thread 
    // should terminate by calling pthread_exit() rather than exit(3). 
    pthread_exit(NULL); 


} /* main() */

