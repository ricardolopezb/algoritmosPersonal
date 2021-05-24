package lists;

public class Node<T> {
     T value;
     Node<T> next;
    public Node(){
        value = null;
        next = null;
    }
    public Node(T value) {
        this.value = value;
        next = null;
    }
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

}
