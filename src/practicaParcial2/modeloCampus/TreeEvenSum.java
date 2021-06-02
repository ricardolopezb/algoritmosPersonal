package practicaParcial2.modeloCampus;

import ArbolBinarioDeBusqueda.BSTException;
import ArbolBinarioDeBusqueda.BinarySearchTree;
import binaryTree.BinaryTree;

public class TreeEvenSum {

    public static BinaryTree<Integer> calculateEvenSum(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return new BinaryTree<>();
        BinaryTree<Integer> treeToReturn = new BinaryTree<>(sumEvens(tree), calculateEvenSum(tree.getLeft()), calculateEvenSum(tree.getRight()));
        return treeToReturn;
    }

    private static int sumEvens(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return 0;
        else if(tree.getRoot()%2 == 0) return tree.getRoot() + sumEvens(tree.getLeft()) + sumEvens(tree.getRight());
        else return sumEvens(tree.getRight()) + sumEvens(tree.getLeft());
    }


    /*
    b)	un método que determine si un objeto dado se encuentra en las hojas de un
    árbol binario (el árbol puede tener elementos repetidos).
     */

    public static boolean checkIfLeaf(BinaryTree<Integer> tree, Integer elem){
        if(tree.isEmpty()) return false;
        if((tree.getRight().isEmpty() && tree.getLeft().isEmpty()) && tree.getRoot().equals(elem)) return true;
        else return checkIfLeaf(tree.getLeft(), elem) || checkIfLeaf(tree.getRight(), elem);

    }

    public static BinarySearchTree<Cuenta>[] distributeTree(BinaryTree<Cuenta> tree){
        BinarySearchTree<Cuenta> sucA = new BinarySearchTree<>();
        BinarySearchTree<Cuenta> sucB = new BinarySearchTree<>();
        insertIntoTrees(tree, sucA, sucB);
        return new BinarySearchTree[]{sucA, sucB};
    }


    private static void insertIntoTrees(BinaryTree<Cuenta> tree, BinarySearchTree<Cuenta> sucA, BinarySearchTree<Cuenta> sucB){
        if(tree.isEmpty()) return;
        try{
            if(tree.getRoot().getSucursal() == 'A') sucA.insert(tree.getRoot());
            else if(tree.getRoot().getSucursal() == 'B') sucB.insert(tree.getRoot());
            insertIntoTrees(tree.getRight(), sucA, sucB);
            insertIntoTrees(tree.getLeft(), sucA, sucB);

        }catch(Exception e){e.getMessage();}

    }


}
