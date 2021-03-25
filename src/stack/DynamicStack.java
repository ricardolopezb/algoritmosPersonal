package stack;

import util.IsEmptyException;
import util.Node;

public class DynamicStack<T> implements StackInterface<T> {

    Node top = null;
    private int size = 0;


    @Override
    public void stack(T x) {
        Node aux = new Node();
        aux.data = x;
        aux.pointer = top;
        top = aux;
        this.size++;

    }

    @Override
    public void pop() throws IsEmptyException {
        if(size == 0) throw new IsEmptyException("The stack has no elements to pop");

        this.top = this.top.pointer;
        this.size--;

    }

    @Override
    public T peek() {
        return (T)top.data;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void empty() {
        this.top = null;
        this.size = 0;
    }
}
