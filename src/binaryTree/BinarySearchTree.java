package ArbolBinarioDeBusqueda;


import binaryTree.BinaryTree;
import binaryTree.DoubleNode;
import util.*;

public class BinarySearchTree <T> extends BinaryTree<T> {
    // Implementacion de un arbol binario de busqueda no balanceado
    // Autor Alicia Gioia

    private DoubleNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable <T> x) throws BSTException {
        root = insert(root, x);
    }


    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable <T> x) throws BSTException {
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin(){
        return getMin(root).getData();
    }

    // precondicion: árbol distinto de vacío
    public T getMax(){
        return getMax(root).getData();
    }

    // precondicion: elemnto a buscar pertenece al arbol
    public T search(Comparable<T> x){
        return search(root, x).getData();
    }

    // precondicion: -
    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty(){
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot(){
        return root.getData();
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.getLeft();
        return t;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.getRight();
        return t;
    }


    // METODOS PRIVADOS
    private DoubleNode<T> getMax(DoubleNode <T> t){
        if (t.getRight() == null)
            return t;
        else
            return getMax(t.getRight());
    }

    private DoubleNode <T> getMin(DoubleNode <T> t){
        if (t.getLeft() == null)
            return t;
        else
            return getMin(t.getLeft());
    }

    private DoubleNode <T> search(DoubleNode <T> t, Comparable<T> x){
        if (x == null) throw new NullPointerException();
        if (x.compareTo(t.getData())== 0)
            return t;
        else if (x.compareTo( t.getData())< 0)
            return search(t.getLeft(), x);
        else
            return search(t.getRight(), x);
    }

    private boolean exists(DoubleNode <T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.getData()) == 0)
            return true;
        else if (x.compareTo( t.getData())< 0)
            return exists(t.getLeft(), x);
        else
            return exists(t.getRight(), x);
    }


    private DoubleNode<T> insert (DoubleNode <T> t, Comparable <T> x) throws BSTException {
        if (exists(x)) throw new BSTException("Item already exists in the tree.");
        if (t == null){
            t = new DoubleNode<T>();
            t.setData((T) x);

        }
        else if (x.compareTo(t.getData()) < 0)
            t.setLeft(insert(t.getLeft(), x));
        else
            t.setRight(insert(t.getRight(), x));
        return t;
    }


    private DoubleNode<T> delete (DoubleNode<T> t, Comparable<T> x) throws BSTException {
        if (!exists(x)) throw new BSTException("Element does not exist in the tree.");
        if (x.compareTo(t.getData()) < 0)
            t.setLeft(delete(t.getLeft(), x));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(delete(t.getRight(), x));
        else
        if (t.getLeft() != null && t.getRight() != null ) {
            t.setData((T) getMin(t.getRight()).getData());
            t.setRight(deleteMin(t.getRight()));
        }
        else if (t.getLeft() != null)
            t = t.getLeft();
        else
            t =t.getRight();
        return t;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t){
        if (t.getLeft() != null)
            t.setLeft(deleteMin(t.getLeft()));
        else
            t = t.getRight();
        return t;
    }
}

