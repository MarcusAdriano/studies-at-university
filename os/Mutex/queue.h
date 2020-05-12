#ifndef QUEUE_H
#define QUEUE_H

typedef struct _queue queue_t;

#define LOCK 0
#define UNLOCK 1

void queue_init();
int queue_add(queue_t*, int);
int queue_next(queue_t*, int*);
int queue_qtt(queue_t*);
void *queue_mutex(queue_t*);
int queue_getlock(queue_t *);
void queue_setlock(queue_t*, int);
int queue_getbwc(queue_t *);
void queue_setbwc(queue_t *, int);
#endif //QUEUE_H
