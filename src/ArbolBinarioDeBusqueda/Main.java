package ArbolBinarioDeBusqueda;

import binaryTree.BinaryTreeApi;

import java.util.ArrayList;

/*******************************************************************************************
 *
 * Author/s = Catalini Camila, Demitropulos Alejo, Encina Santiago, Lopez Bonaguro, Ricardo
 *
 * *****************************************************************************************/


public class Main {


    public static void main(String[] args) throws IncompatibleCode {
        ArrayList<Organism> list = new ArrayList<>();

        //Creation of the organism samples
        Organism organism1 = new Organism("AAAAA","type","description",0,0);
        Organism organism2 = new Organism("BBBBB","type","description",0,0);
        Organism organism3 = new Organism("CCCCC","type","description",0,0);
        Organism organism4 = new Organism("DDDDD","type","description",0,0);
        Organism organism5 = new Organism("EEEEE","type","description",0,0);

        //we add them to the list
        list.add(organism2);
        list.add(organism3);
        list.add(organism1);
        list.add(organism5);
        list.add(organism4);

        //Creation of the tree and the object in charge of managing the movement from  list to tree.
        BinarySearchTree<Organism> tree = new BinarySearchTree<>();
        memoryManager dataTransporter = new memoryManager();

        try {
            dataTransporter.transport(tree,list);
            dataTransporter.inform(tree);
            //we eliminate an organism to test the method
            dataTransporter.eliminate(tree,"aaaaa");
        }catch (BSTException e){
            e.getMessage();
        }
         //Some information of the tree
        dataTransporter.inform(tree);
        System.out.println("");
        dataTransporter.getInfo(tree,organism1);
        dataTransporter.getInfo(tree,organism2);


    }



}
