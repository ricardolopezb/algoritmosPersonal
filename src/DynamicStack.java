public class DynamicStack<T> implements Stack<T> {

    Node top = null;


    @Override
    public void push(T x) {
        Node aux = new Node();
        aux.data = x;
        aux.pointer = top.pointer;
        top = aux;

    }

    @Override
    public void pop() {

    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
