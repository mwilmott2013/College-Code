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


bool isTobacco, isPaper, isMatch = false;

Semaphore agentSem(1);
Semaphore tobacco(0);
Semaphore paper(0);
Semaphore match(0);
Semaphore tobaccoSem(0);
Semaphore paperSem(0);
Semaphore matchSem(0);
Semaphore mutex(1);



void *pusherOne ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		tobacco.wait();
		mutex.wait();
			if (isPaper) {
				isPaper =false;
				matchSem.signal();
			} else if (isMatch) {
				isMatch = false;
				paperSem.signal();
			} else {
				isTobacco = true;
			}
		mutex.signal();
		
    }

}

void *pusherTwo ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		paper.wait();
		mutex.wait();
			if (isMatch) {
				isMatch = false;
				tobaccoSem.signal();
			} else if (isTobacco) {
				isTobacco = false;
				matchSem.signal();
			} else {
				isPaper = true;
			}
		mutex.signal();
		
    }

}

void *pusherThree ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		match.wait();
		mutex.wait();
			if (isPaper) {
				isPaper =false;
				tobaccoSem.signal();
			} else if (isTobacco) {
				isTobacco = false;
				paperSem.signal();
			} else {
				isMatch = true;
			}
		mutex.signal();
		
    }

}

void *smokerT ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		tobaccoSem.wait();
		printf("Tobacco smoker is making a cigarette.");
		agentSem.signal();
		printf("Tobacco smoker is smoking.");
    }

}

void *smokerM ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		matchSem.wait();
		printf("Match smoker is making a cigarette.");
		agentSem.signal();
		printf("Match smoker is smoking.");
    }

}

void *smokerP ()
{

    while( 1 )
    {
        sleep(3); // Slow the thread down a bit so we can see what is going on
		
		paperSem.wait();
		printf("Paper smoker is making a cigarette.");
		agentSem.signal();
		printf("Paper smoker is smoking.");
    }

}

void *Agent ()
{
	srand(6)
	while ( 1 )
	{
		sleep(3); // Slow the thread down a bit so we can see what is going on
		
		agentSem.wait();
		int supply = rand(2);
		
		if (supply == 0) {
			tobacco.signal();
			paper.signal();
		} else if (supply == 1) {
			paper.signal();
			match.signal();
		} else {
			tobacco.signal();
			match.signal();
		}
	}

}

int main(int argc, char **argv )
{
    pthread_t tsmokerThread;
	pthread_t psmokerThread;
	pthread_t msmokerThread;
	pthread_t agentThread;
	pthread_t pusherOneThread;
	pthread_t pusherTwoThread;
	pthread_t pusherThreeThread;
	

    // Create the seven 
        int a = pthread_create ( &tsmokerThread, NULL, 
                                  smokerT, (void *));
        if (a) {
            printf("ERROR creating tobacco smoker thread # %d; \
                    return code from pthread_create() is %d\n", a);
            exit(-1);
        }
		
		int b = pthread_create ( &psmokerThread, NULL, 
                                  smokerP, (void *));
        if (b) {
            printf("ERROR creating paper smoker thread # %d; \
                    return code from pthread_create() is %d\n", b);
            exit(-1);
        }
		
		int c = pthread_create ( &msmokerThread, NULL, 
                                  smokerT, (void *));
        if (c) {
            printf("ERROR creating match smoker thread # %d; \
                    return code from pthread_create() is %d\n", c);
            exit(-1);
        }
		
		int e = pthread_create ( &agentThread, NULL, 
                                  smokerT, (void *));
        if (e) {
            printf("ERROR creating agent thread # %d; \
                    return code from pthread_create() is %d\n", e);
            exit(-1);
        }
		
		int f = pthread_create ( &pusherOneThread, NULL, 
                                  smokerT, (void *));
        if (f) {
            printf("ERROR creating first pusher thread # %d; \
                    return code from pthread_create() is %d\n", f);
            exit(-1);
        }
		
		int g = pthread_create ( &pusherTwoThread, NULL, 
                                  smokerT, (void *));
        if (g) {
            printf("ERROR creating second pusher thread # %d; \
                    return code from pthread_create() is %d\n", g);
            exit(-1);
        }
		
		int h = pthread_create ( &pusherThreeThread, NULL, 
                                  smokerT, (void *));
        if (h) {
            printf("ERROR creating third pusher thread # %d; \
                    return code from pthread_create() is %d\n", h);
            exit(-1);
        }

    printf("Main: program completed. Exiting.\n");


    // To allow other threads to continue execution, the main thread 
    // should terminate by calling pthread_exit() rather than exit(3). 
    pthread_exit(NULL); 


} /* main() */

