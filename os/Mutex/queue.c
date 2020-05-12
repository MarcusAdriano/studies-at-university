#include "queue.h"
#include <stdlib.h>
#include <semaphore.h>

#define CAPACITY 10

struct _queue {
    int queue[CAPACITY]; // define a static/array queue
    int next;            // define the next element of the queue
    int top;             // define the last element on queue
    int qtt;             // define quantity of element on queue
    int lock;            // define queue is available to receive elements
    sem_t mutex;         // used only semaphone mutual exclusion
    int bwc;             // used only busy wait controller
};

void queue_init(queue_t *f) {
    f->next = 0;
    f->top = 0;
    f->qtt = 0;
    f->bwc = 0;
    f->lock = UNLOCK;
}

int queue_add(queue_t *f, int a) {
    if (f->qtt == CAPACITY || f->lock == LOCK)
        return -1;

    f->queue[f->top++] = a;
    f->top = f->top % CAPACITY;
    f->qtt++;
    return 0;
}

int queue_next(queue_t *f, int *a) {
    if (f->qtt == 0)
        return -1;

    if (a == NULL)
        a = (int*) malloc(sizeof(int));

    *a = f->queue[f->next++];
    f->next = f->next % CAPACITY;
    f->qtt--;
    return 0;
}

int queue_qtt(queue_t *f) {
    return f->qtt;
}

void *queue_mutex(queue_t *f) {
    return &(f->mutex);
}

void queue_setbwc(queue_t *f, int a) {
    f->bwc = a;
}

int queue_getbwc(queue_t *f) {
    return f->bwc;
}

int queue_getlock(queue_t *f) {
    return f->lock;
}

void queue_setlock(queue_t*f, int a) {
    f->lock = a;
}
