package practicaParcial2.modeloCampus;

import ArbolBinarioDeBusqueda.BinarySearchTree;
import binaryTree.BinaryTree;
import binaryTree.BinaryTreeApi;
import org.junit.Assert;
import org.junit.Test;

public class Tester {
    static BinaryTree<Integer> tree = new BinaryTree<Integer>(5, new BinaryTree<Integer>(20, new BinaryTree<Integer>(2), new BinaryTree<>()), new BinaryTree<Integer>(3, new BinaryTree<Integer>(9), new BinaryTree<Integer>(5)));
    static BinaryTree<Integer> finishedTree = new BinaryTree<Integer>(22, new BinaryTree<Integer>(22, new BinaryTree<Integer>(2), new BinaryTree<>()), new BinaryTree<Integer>(0, new BinaryTree<Integer>(0), new BinaryTree<Integer>(0)));
    static BinaryTreeApi api = new BinaryTreeApi();

    static Cuenta[] cuentas = {
            new Cuenta('A', 10),
            new Cuenta('B', 7),
            new Cuenta('B', 9),
            new Cuenta('A', 2),
            new Cuenta('A', 30),
            new Cuenta('B', 30)
    };
    static BinaryTree<Cuenta> cuentasTree = new BinaryTree<Cuenta>(cuentas[0], new BinaryTree<Cuenta>(cuentas[1], new BinaryTree<Cuenta>(cuentas[3]), new BinaryTree<>()), new BinaryTree<Cuenta>(cuentas[2], new BinaryTree<Cuenta>(cuentas[4]), new BinaryTree<Cuenta>(cuentas[5])));


    public static void main(String[] args) {
        BinarySearchTree<Cuenta>[] trees = TreeEvenSum.distributeTree(cuentasTree);
        //api.perLevel(cuentasTree);
        System.out.println("*********");
        api.perLevel(trees[0]);
        api.perLevel(trees[1]);
    }

    @Test
    public void isomorphicInitialTreesTest(){
        Assert.assertTrue(api.areIsomorphics(tree, finishedTree));
    }

    @Test
    public void check(){
        Assert.assertTrue(api.equals(finishedTree, TreeEvenSum.calculateEvenSum(tree)));
    }

    @Test
    public void checkIfLeafTest(){
        Assert.assertTrue(TreeEvenSum.checkIfLeaf(tree, 5));
        Assert.assertTrue(TreeEvenSum.checkIfLeaf(finishedTree, 0));
        Assert.assertFalse(TreeEvenSum.checkIfLeaf(finishedTree, 22));
    }


}
