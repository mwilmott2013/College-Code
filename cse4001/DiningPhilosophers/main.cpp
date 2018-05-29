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

const int numPhilosophers = 5;


Semaphore footman(4);
Semaphore forks[5];
int readers = 0;



void *Dine ( void *threadID )
{

	int i = (long)threadID;
    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		footman.wait();
		forks[(i+1) % 5].wait();
		forks[i].wait();
		
		printf("Philosopher " + i + " is eating");
		
		forks[(i+1) % 5].signal();
		forks[i].signal();
		footman.signal();
		
		printf("Philosopher " + i + " is thinking");
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
    pthread_t philosopherThread[ numPhilosophers ];
	
	for (int f = 0; f < numPhilosophers; f++) {
		forks[i] = Semaphore(1);
	}

    // Create the philosophers 
    for( long p = 0; p < numPhilosophers; p++ )
    {
        int t = pthread_create ( &philosopherThread[ p ], NULL, 
                                  Dine, (void *) (p+1) );
        if (t) {
            printf("ERROR creating philosopher thread # %d; \
                    return code from pthread_create() is %d\n", p, t);
            exit(-1);
        }
    }

    printf("Main: program completed. Exiting.\n");


    // To allow other threads to continue execution, the main thread 
    // should terminate by calling pthread_exit() rather than exit(3). 
    pthread_exit(NULL); 


} /* main() */

