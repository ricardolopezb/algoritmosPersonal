package lists;

public class DoubleNode <T>{
    T value;
    DoubleNode<T> prev, next;

    public DoubleNode(T o) {
        value = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
        value = o;
        this.prev = right;
        this.next = left;
    }
}
