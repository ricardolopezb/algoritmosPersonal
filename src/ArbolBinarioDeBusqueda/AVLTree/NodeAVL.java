package ArbolBinarioDeBusqueda.AVLTree;

public class NodeAVL<T> {
    T element; // The data in the node
    NodeAVL<T> left; // Left child
    NodeAVL<T> right; // Right child
    public int height; // Height

    NodeAVL( T theElement ) {
        this( theElement, null, null );
    }

    NodeAVL( T theElement, NodeAVL<T> lt, NodeAVL<T> rt ) {
        element = theElement; left = lt; right = rt; height = 0;
    }

    @Override
    public String toString() {
        return "NodeAVL{" +
                "element=" + element +
                '}';
    }
}

