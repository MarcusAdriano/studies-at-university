#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include <semaphore.h>
#include <time.h>
#include "queue.h"

sem_t *mutex;    /* global mutex */
queue_t *squeue; /* shared queue */
int pid4;       /* pid P4 - consumer */
void manipulate_queue();

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("somethings is wrong, try run again later!\n");
        exit(-1);
    }

    sscanf(argv[1], "%d", &pid4);

    void *shared_memory = (void *)0; /* shared quote */

    key_t key = 1441; /* key to be passed to shmget() */
    int shmflg = 0666|IPC_CREAT; /* shmflg to be passed to shmget() */
    int size = sizeof(queue_t*);
    int shmid; /* return value from shmget() */

    /* Create shared memory and check for errors */
    shmid = shmget(key, size, shmflg);
	if ( shmid == -1 ) {
    	printf("error shmget: %s\n", strerror(errno));
		exit(-1);
	}

    /* shared memory attached */
    shared_memory = shmat(shmid, NULL, 0);

    /* check for errors on shmat */
	if (shared_memory == (void*) -1) {
		printf("error shmat: %s\n", strerror(errno));
        exit(-1);
	}

    /* get memory space for queue and initialize */
    squeue = (queue_t *) shared_memory;
    queue_init(squeue);
    mutex = (sem_t*) queue_mutex(squeue);

    /* initialize semaphore */
    if (sem_init(mutex, 1, 1) != 0) {
        printf("error sem_init: %s\n", strerror(errno));
        shmdt(shared_memory);
        exit(-1);
    }


    int i;
    pid_t pids[2];
    for (i = 0; i < 2; i++) {
        pids[i] = fork();
        if (pids[i] == 0) {
            // p1 and p2
            // TODO Process begin
            srand(time(NULL) + (int) getpid());

            while (1) {
                manipulate_queue();
            }
            exit(0); // Exit process
        }
    }

    srand(time(NULL) + (int) getpid());
    while (1) {
        manipulate_queue();
    }
    return 0;
}

void manipulate_queue() {
    int i;
    sem_wait(mutex); // ########## mutex wait HERE!!
        if (queue_qtt(squeue) < 10 && queue_getlock(squeue) == UNLOCK) {
            i = rand() % 1000 + 1;

            if (queue_add(squeue, i) != 0) {
                printf("error to add item on queue!\n");
            } else {
                //printf("Process (%d) enqueue %d, queue size is %d\n",
                //        getpid(), i, queue_qtt(squeue));
            }

            if (queue_qtt(squeue) == 10)
                kill(pid4, SIGUSR1);
        }
    sem_post(mutex); // ########### mutex post HERE!!
}
