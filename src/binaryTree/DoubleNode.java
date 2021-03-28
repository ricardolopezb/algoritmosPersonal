package binaryTree;

public class DoubleNode<T> {
    T dato;
    DoubleNode<T> right;
    DoubleNode<T> left;

    public DoubleNode(T o){
        this.dato = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        this.dato = o;
        this.left = left;
        this.right = right;
    }

}
