package ArbolBinarioDeBusqueda.RedBlackTree;


public class RedBlackNode<T> {
    Comparable<T> data;
    RedBlackNode parent;
    RedBlackNode left;
    RedBlackNode right;
    int color; // 1 . Red, 0 . Black

    @Override
    public String toString() {
        return "data=" + data + ", color=" + color;
    }


}