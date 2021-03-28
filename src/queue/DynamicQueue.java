package queue;

import util.IsEmptyException;
import util.Node;

public class DynamicQueue<T> implements QueueInterface<T> {

    private Node back;
    private Node front;
    private int size = 0;

    @Override
    public void enqueue(T x) {
        if(isEmpty()){
            back = new Node();
            back.data = x;
            front = back;

        } else {
            Node aux = new Node();
            aux.data = x;
            back.pointer = aux;
            back = aux;
        }
        size++;

    }

    @Override
    public T dequeue() throws IsEmptyException {
        if(isEmpty()) throw new IsEmptyException("The queue has no elements to dequeue");

        T toReturn = (T) front.data;
        front = front.pointer;
        size--;
        return toReturn;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
