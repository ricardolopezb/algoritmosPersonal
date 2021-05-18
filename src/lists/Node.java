package lists;

/**
 * Created by Oscar on 23/03/2017.
 */
public class Node <T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
