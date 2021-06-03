package practicaParcial2.modeloCampus;

import ArbolBinarioDeBusqueda.BinarySearchTree;
import binaryTree.BinaryTree;
import binaryTree.BinaryTreeApi;
import org.junit.Assert;
import org.junit.Test;

public class Tester {
    static BinaryTree<Integer> tree = new BinaryTree<Integer>(5, new BinaryTree<Integer>(20, new BinaryTree<Integer>(2), new BinaryTree<>()), new BinaryTree<Integer>(3, new BinaryTree<Integer>(9), new BinaryTree<Integer>(5)));
    static BinaryTree<Integer> tree4 = new BinaryTree<Integer>(22, new BinaryTree<Integer>(0, new BinaryTree<Integer>(0), new BinaryTree<>()), new BinaryTree<Integer>(17, new BinaryTree<Integer>(9), new BinaryTree<Integer>(5)));
    static BinaryTree<Integer> finishedTree = new BinaryTree<Integer>(22, new BinaryTree<Integer>(22, new BinaryTree<Integer>(2), new BinaryTree<>()), new BinaryTree<Integer>(0, new BinaryTree<Integer>(0), new BinaryTree<Integer>(0)));
    static BinaryTreeApi api = new BinaryTreeApi();
    static BinaryTree<Integer> reflected_tree = new BinaryTree<Integer>(5, new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(9)), new BinaryTree<Integer>(20, new BinaryTree<Integer>(), new BinaryTree<>(2)));

    static Cuenta[] cuentas = {
            new Cuenta('A', 10),
            new Cuenta('B', 7),
            new Cuenta('B', 9),
            new Cuenta('A', 2),
            new Cuenta('A', 30),
            new Cuenta('B', 30)
    };
    static BinaryTree<Cuenta> cuentasTree = new BinaryTree<Cuenta>(cuentas[0], new BinaryTree<Cuenta>(cuentas[1], new BinaryTree<Cuenta>(cuentas[3]), new BinaryTree<>()), new BinaryTree<Cuenta>(cuentas[2], new BinaryTree<Cuenta>(cuentas[4]), new BinaryTree<Cuenta>(cuentas[5])));

    static BinaryTree<Integer> tree1 = new BinaryTree<>(80);
    static BinaryTree<Integer> tree2 = new BinaryTree<>(90);
    static BinaryTree<Integer> arbolinComparable = new BinaryTree<Integer>(9, tree1, tree2);

    static Parcial2020 esBSTdadoBS = new Parcial2020();
    static Parcial2020 p = new Parcial2020();


    @Test
    public void checkBST(){
        Assert.assertFalse(esBSTdadoBS.isBST(arbolinComparable));
    }


    @Test
    public void checkReflection(){
        Assert.assertTrue(api.equals(p.reflect(tree), reflected_tree));
    }

    @Test
    public void BSTCreationTest(){
        BinaryTree<Comparable> t= new BinaryTree<Comparable>(5, new BinaryTree<Comparable>(10), new BinaryTree<Comparable>(50));
        BinarySearchTree<Comparable> bst = p.makeBSTfromBT(t);
        api.inorder(t);
        api.inorder(bst);
    }


    @Test
    public void oddSumTreeTest(){
        Assert.assertTrue(api.equals(tree4, p.getOddSumTree(tree)));
    }


    public static void main(String[] args) {
        try{
            //p.generateProvinces();
            //p.showSortedProvPerRain();
            p.generateCalls();
            p.callsLongerThan7min();
            p.callsPerCountry();

        } catch(Exception e){e.getMessage();}
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
