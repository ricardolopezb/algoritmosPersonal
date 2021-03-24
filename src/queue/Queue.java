package queue;

public interface Queue<T> {
    void enqueue(T x);
    T dequeue();
    int size();
    boolean isEmpty();
}
