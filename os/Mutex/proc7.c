#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>
#include <time.h>
#include "queue.h"

#define QTDE 1000
#define INTE 100

queue_t *squeue;
void* thr_consumer(void*);
int ite;
int val[QTDE] = {0};

int main() {
    void *shared_memory = (void *)0; /* shared quote */

    key_t key = 1442; /* key to be passed to shmget() */
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

    /* get memory space for queue and initialize */
    squeue = (queue_t *) shared_memory;

    pthread_t t1, t2, t3;
    int a = 2, b = 3, c = 4, i;
    pthread_create(&t1, NULL, thr_consumer, (void*) &a);
    pthread_create(&t2, NULL, thr_consumer, (void*) &b);
    pthread_create(&t3, NULL, thr_consumer, (void*) &c);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);

    // RESULTS
    int moda = 0, min = -1, max = 0;
    for (i = 1; i < QTDE; i++) {
        if (val[i] > val[moda]) {
            moda = i;
        }

        if (val[i - 1] > 0 && min == -1) {
            min = i;
        }

        if (val[i] > 0 && i > max) {
            max = i;
        }
    }

    printf("MODA = \t%d\nMAX  = \t%d\nMIN  = \t%d\n", moda + 1, max + 1, min + 1);
    shmdt(shared_memory);
    return 0;
}

void* thr_consumer(void*arg) {
    int a, *tr = (int*) arg, bk = 1, th_x;

    while (bk) {
        if ((th_x = queue_getbwc(squeue)) == (*tr)) {
            if (queue_qtt(squeue) == 0) {
                th_x = (th_x + 1) % 5; /* change thread to dequeue */
                queue_setbwc(squeue, th_x);    /****/
                continue;
            }
            if (ite < INTE) {
                queue_next(squeue, &a);
                printf("(%d) Dequeued(%d) = %d\n", ite + 1, (*tr), a);
                val[a - 1]++;
                ite++;

                th_x = (th_x + 1) % 5; /* change thread to dequeue */
                queue_setbwc(squeue, th_x);    /****/
            } else {
                bk = 0;
                queue_setbwc(squeue, -1);    /****/
            }
        } else if (th_x == -1){
            bk = 0;
        }
    }
    pthread_exit(0);
}
