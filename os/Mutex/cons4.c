#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>
#include <semaphore.h>
#include <time.h>
#include "queue.h"

queue_t *squeue, *squeue2; /* shared queue */
void signal_handler();
void* create_shmqueue();
void* thr_consumer(void*);
int pipe1[2];
int pipe2[2];
sem_t *mutex;

int main() {
    // PROCES 5 and 6 ##########################################################

    /* Create pipe 1 and 2 */
    if ( pipe(pipe1) == -1 ){ printf("Error pipe1()"); return -1; }
    if ( pipe(pipe2) == -1 ){ printf("Error pipe2()"); return -1; }

    squeue2 = (queue_t*) create_shmqueue(1442);
    queue_init(squeue2);

    pid_t pids[2];
    int a, bk = 1, p, i, th_x, p5 = 0, p6 = 0;
    for (i = 0; i < 2; i++) {
        // PROCESS 5 AND 6 #####################################################
        p = i;
        pids[i] = fork();
        if (pids[i] == 0) {

            while (bk) {
                if ((th_x = queue_getbwc(squeue2)) == p) {

                    if (queue_qtt(squeue2) == 10) {
                        th_x = (th_x + 1) % 5;
                        queue_setbwc(squeue2, th_x);
                        continue;
                    }

                    if (p == 1) {
                        read(pipe2[0], &a, sizeof(int));
                        p6++;
                    } else {
                        read(pipe1[0], &a, sizeof(int));
                        p5++;
                    }

                    queue_add(squeue2, a) != 0;

                    th_x = (th_x + 1) % 5;
                    queue_setbwc(squeue2, th_x);
                } else if (th_x == -1) {
                    bk = 0;
                }
            }

            if (p == 0)
                printf("MANI. by P5 = %d\n", p5);
            else
                printf("MANI. by P6 = %d\n", p6);
            exit(0); //  #######################################################
        }
    }

    // #########################################################################
    // PROCESS 4 ###############################################################
    printf("PID P4 = %d\n", getpid());

    /* get memory space for queue and initialize */
    squeue = (queue_t *) create_shmqueue(1441);
    mutex = (sem_t*) queue_mutex(squeue);

    /* set signal handler for this process */
    signal(SIGUSR1, signal_handler);
    getchar();
    // #########################################################################
    return 0;
}

void* thr_consumer(void*arg) {
    int a, *tr = (int*) arg, bk = 1;

    while (bk) {
        sem_wait(mutex); // MUTEX WAIT #########################################
            if (queue_qtt(squeue) > 0) {
                queue_next(squeue, &a);
                //printf("Dequeued %d from = [T%d]\n", a, (*tr));

                if ((*tr) == 1) {
                    write(pipe2[1], &a, sizeof(int));
                } else {
                    write(pipe1[1], &a, sizeof(int));
                }
            } else {
                bk = 0;
            }
        sem_post(mutex); // MUTEX POST #########################################
    }
    pthread_exit(0);
}

void signal_handler() {
    pthread_t t5, t6;
    int i, x = 0, y = 1; /* t5 access = 0, t6 access = 1 */

    queue_setlock(squeue, LOCK); /*lock queue */
    if (pthread_create(&t5, NULL, thr_consumer, (void*) &x) != 0) {
        printf("error to create t5!\n");
        exit(-1);
    }

    if (pthread_create(&t6, NULL, thr_consumer, (void*) &y) != 0) {
        printf("error to create t5!\n");
        exit(-1);
    }

    pthread_join(t5, NULL);
    pthread_join(t6, NULL);

    queue_setlock(squeue, UNLOCK); /*unlock queue */
}

void* create_shmqueue(key_t k) {
    void *shared_memory = (void *)0; /* shared quote */

    key_t key = k; /* key to be passed to shmget() */
    int shmflg = 0666|IPC_CREAT; /* shmflg to be passed to shmget() */
    int size = sizeof(queue_t*);
    int shmid; /* return value from shmget() */

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

    return shared_memory;
}
