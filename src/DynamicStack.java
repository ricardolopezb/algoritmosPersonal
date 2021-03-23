public class DynamicStack<T> implements Stack<T> {

    Node top = null;
    private int size = 0;


    @Override
    public void push(T x) {
        Node aux = new Node();
        aux.data = x;
        aux.pointer = top;
        top = aux;
        this.size++;

    }

    @Override
    public void pop() {
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
}
