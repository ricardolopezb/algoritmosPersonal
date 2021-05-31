package binaryTree;

public class BinaryTree<T> {
    private DoubleNode<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(T obj){
        this.root = new DoubleNode<>(obj);
    }

    public BinaryTree(T obj, BinaryTree<T> tleft, BinaryTree<T> tright){
        this.root = new DoubleNode<T>(obj, tleft.root, tright.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public T getRoot(){
        return root.data;
    }

    public BinaryTree<T> getLeft(){
        BinaryTree<T> toReturn = new BinaryTree<>();
        toReturn.root = root.left;
        return toReturn;
    }

    public BinaryTree<T> getRight(){
        BinaryTree<T> toReturn = new BinaryTree<>();
        toReturn.root = root.right;
        return toReturn;
    }


}
