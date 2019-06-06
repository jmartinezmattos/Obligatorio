package TADS.Queue.SimpleQueue;
public interface MyQueue<T> {
    void enqueue (T element) throws QueueFullException, TADS.Queue.CircularQueue.QueueFullException;
    T dequeue () throws EmptyQueueException, TADS.Queue.CircularQueue.EmptyQueueException;
    boolean isEmpty();
    public T getFirst() throws EmptyQueueException, TADS.Queue.CircularQueue.EmptyQueueException;
}