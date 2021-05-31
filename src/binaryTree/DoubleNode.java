package binaryTree;

public class DoubleNode<T> {
    T data;
    DoubleNode<T> right;
    DoubleNode<T> left;

    public DoubleNode(){
        this.data = null;
    }

    public DoubleNode(T o){
        this.data = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        this.data = o;
        this.left = left;
        this.right = right;
    }
    public T getData() {
        return data;
    }

    public DoubleNode getLeft() {
        return left;
    }

    public DoubleNode getRight() {
        return right;
    }

    public boolean isEmpty() {
        return data == null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(DoubleNode left) {
        this.left = left;
    }

    public void setRight(DoubleNode right) {
        this.right = right;
    }

}
