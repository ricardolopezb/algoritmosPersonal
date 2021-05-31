package ArbolBinarioDeBusqueda;

import java.util.ArrayList;
import binaryTree.BinaryTreeApi;

public class memoryManager<T> {


    public memoryManager() {
    }

    public void transport(BinarySearchTree<Organism> tree, ArrayList<Organism> list) throws BSTException {

        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }

    }

    public void eliminate(BinarySearchTree<Organism> tree, String code) throws BSTException, IncompatibleCode {
        Organism organism=new Organism(code,null,null,0,0);
        tree.delete(organism);
    }

    public void inform(BinarySearchTree<Organism> tree){
        BinaryTreeApi api=new BinaryTreeApi();
        int size=api.size(tree);
        System.out.println("\nThere are "+size+" organisms in memory.");
        System.out.println("This is a list of all the organisms ordered by level:");

        ArrayList<Organism> perLevel = new ArrayList<>();

        api.perLevel(tree,perLevel);

        for (int i = 0; i < perLevel.size(); i++) {
            System.out.println(perLevel.get(i).getCode());
        }

        System.out.println("****************************************************************");
    }

    public void getInfo(BinarySearchTree<Organism> tree,Organism organism){
        System.out.println();
        if (tree.exists(organism)){
            System.out.println("Organism's info:\n"+organism.toString()+"\n****************************************************************");

        }else{
            System.out.println("The organism does not exist\n****************************************************************");
        }

    }

    }





