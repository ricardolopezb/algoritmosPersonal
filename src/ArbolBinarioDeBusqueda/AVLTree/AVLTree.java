package ArbolBinarioDeBusqueda.AVLTree;

public class AVLTree<T> {
    private NodeAVL<T> root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(T o) {
        root = new NodeAVL<>(o);
    }

    public AVLTree(T o, AVLTree<T> tLeft, AVLTree<T> tRight) {
        root = new NodeAVL<>(o, tLeft.root, tRight.root);
    }

    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }

    private boolean exists(NodeAVL<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.element) == 0)
            return true;
        else if (x.compareTo( t.element)< 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }

    public int height(NodeAVL<T> n) {
        if (n == null)
            return 0;

        return n.height;
    }

    public NodeAVL<T> getRoot() {
        return root;
    }

    private NodeAVL<T> insert(Comparable<T> itemToBeInserted, NodeAVL<T> t) {
        if (t == null)
            return new NodeAVL<T>((T) itemToBeInserted, null, null);

        int compareResult = itemToBeInserted.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(itemToBeInserted, t.left);
        else if (compareResult > 0)
            t.right = insert(itemToBeInserted, t.right);
        else
            ; // Duplicate; do nothing
        return balance(t);
    }



    // Assume t is either balanced or within one of being balanced
    private NodeAVL<T> balance(NodeAVL<T> t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > 1)
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else if (height(t.right) - height(t.left) > 1)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }



    public AVLTree<T> getLeft() {
        AVLTree<T> t = new AVLTree<T>();
        t.root = root.left;
        return t;
    }

    public AVLTree<T> getRight() {
        AVLTree<T> t = new AVLTree<T>();
        t.root = root.right;
        return t;
    }

    public void insert(Comparable<T> x) {
        if (!exists(x)) {
            root = insert(x, root);
        } else {
            throw new IllegalArgumentException("te element already exists in the tree");
        }
    }

    private NodeAVL<T> insert(NodeAVL<T> t, Comparable<T> x) {
        if (t == null) {
            t = new NodeAVL<>((T) x);
        } else if (x.compareTo(t.element) < 0) {
            t.left = insert(t.left, x);
        } else {
            t.right = insert(t.right, x);
        }
        return t;
    }

    public void delete(Comparable<T> x) {
        if (exists(x)) {
            root = delete(root, x);
        } else {
            throw new IllegalArgumentException("the element does not exist in the tree");
        }
    }

    private NodeAVL<T> delete(NodeAVL<T> t, Comparable<T> x) {
        if (x.compareTo(t.element) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.element) > 0)
            t.right = delete(t.right, x);
        else if (t.left != null && t.right != null) {
            t.element = getMin(t.right).element;
            t.right = deleteMin(t.right);
        } else if (t.left != null)
            t = t.left;
        else
            t = t.right;
        return t;
    }

    private NodeAVL<T> getMin(NodeAVL<T> t) {
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private NodeAVL<T> deleteMin(NodeAVL<T> t) {
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }


    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     */
    private static NodeAVL rotateWithLeftChild(NodeAVL k2) {
        NodeAVL k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */
    private static NodeAVL rotateWithRightChild(NodeAVL k1) {
        NodeAVL k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     */
    private static NodeAVL doubleWithLeftChild(NodeAVL k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     */
    private static NodeAVL doubleWithRightChild(NodeAVL k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public void preOrden(AVLTree<T> a){
        if(!a.isEmpty()){
            System.out.println(a.root);
            preOrden(a.getLeft());
            preOrden(a.getRight());
        }
    }

    public boolean isEmpty(){
        return root == null;
    }
}
