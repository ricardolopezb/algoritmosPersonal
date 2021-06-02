package practicaParcial2.modeloCampus;

/** Metodos de arboles y Archivos */

import ArbolBinarioDeBusqueda.BSTException;
import ArbolBinarioDeBusqueda.BinarySearchTree;
import binaryTree.BinaryTree;
import lists.OrderedDynamicList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/** Todos los ejercicios pedidos */

public class Parcial2020 {

    /**
     * Un método que determine si un objeto dado se encuentra
     * en las hojas de un árbol binario (el árbol puede tener elementos repetidos).
     */

    public static boolean checkIfLeaf(BinaryTree<Integer> tree, Integer elem){
        if(tree.isEmpty()) return false;
        if((tree.getRight().isEmpty() && tree.getLeft().isEmpty()) && tree.getRoot().equals(elem)) return true;
        else return checkIfLeaf(tree.getLeft(), elem) || checkIfLeaf(tree.getRight(), elem);
    }

    /**
     * Usando solamente las primitivas de BinaryTree y SearchBinaryTree
     * escribir un metodo que recibe un arbol binario y
     * debe verificar si es un arbol binario de busqueda
     */
    public boolean isBST(BinaryTree<Integer> tree ){
        //para que un BT cumpla que es BST tiene que cumplir:
        //subL < Root < subR
        //   if(tree.isEmpty()) return false;
        if(tree.isEmpty() || tree.getLeft().isEmpty() && tree.getRight().isEmpty()) return true;
        if(((tree.getRoot()).compareTo(tree.getLeft().getRoot()) >= 0 ) && (tree.getRoot().compareTo(tree.getRight().getRoot()) <= 0)) {
            return isBST(tree.getLeft()) || isBST(tree.getRight());
        }
        else return false;
    }



    /**
     * Usando solamente las primitivas de BinaryTree desarrollar y probar
     * un metodo que recibe un arbol binario de numeros enteros y devuelve un arbol isomorfo
     * en el cual cada nodo contiene la suma de el junto con todos sus descendientes
     * siempre que sean impares
     */

    public BinaryTree<Integer> getOddSumTree(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return new BinaryTree<>();
        else return new BinaryTree<>(calculateOddSum(tree), getOddSumTree(tree.getLeft()), getOddSumTree(tree.getRight()));
    }

    private int calculateOddSum(BinaryTree<Integer> tree) {
        if(tree.isEmpty()) return 0;
        if(tree.getRoot()%2 != 0) return tree.getRoot() + calculateOddSum(tree.getLeft()) + calculateOddSum(tree.getRight());
        else return calculateOddSum(tree.getLeft()) + calculateOddSum(tree.getRight());
    }


    /**
     * un método que recibe un árbol binario de números enteros y devuelve un árbol isomorfo
     * en el cual cada nodo contiene la suma de él junto con todos sus descendientes.
     */

    public BinaryTree<Integer> getSumTree(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return new BinaryTree<>();
        else return new BinaryTree<>(calculateSum(tree), getSumTree(tree.getLeft()), getSumTree(tree.getRight()));
    }

    private int calculateSum(BinaryTree<Integer> tree) {
        if(tree.isEmpty()) return 0;
        return tree.getRoot() + calculateSum(tree.getLeft()) + calculateSum(tree.getRight());
    }

    /**
     * Usando solamente las primitivas de BinaryTree y SearchBinaryTree
     * escribir un metodo que recibe un arbol binario y con sus elementos
     * construya un arbol binario de busqueda
     */

    public BinarySearchTree<Comparable> makeBSTfromBT(BinaryTree<Comparable> tree){
        BinarySearchTree<Comparable> bst = new BinarySearchTree<>();
        insertIntoBST(tree, bst);
        return bst;
    }

    public void insertIntoBST(BinaryTree<Comparable> tree, BinarySearchTree<Comparable> bst){
        if(tree.isEmpty()) return;
        try{
            bst.insert(tree.getRoot());

        } catch(BSTException e){
            e.getMessage();
        } finally {
            insertIntoBST(tree.getRight(), bst);
            insertIntoBST(tree.getLeft(), bst);
        }

    }



    /**Un Banco utiliza un árbol binario para guardar la información
     * de las cuentas corrientes de los clientes de dos sucursales.
     * Cada cuenta se caracteriza por la sucursal (una letra que puede ser ‘A’ o ‘B’) y un número.
     * Para mayor eficiencia el depto de sistemas ha decidido que a partir de la información almacenada
     * en el árbol binario construir dos árboles binarios de búsqueda, uno con los clientes de la sucursal ‘A’
     * y el otro con los de la sucursal ‘B’.
     Se pide hacer una aplicación que realice lo solicitado y un programa de prueba.
    */


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

     /** Por cada provincia se disopne de un numero de provincia
     * (1: bs as, 2: santa fe, etc) y de 12 numeros de lluvias mensuales.
     * se recibe un archivo de texto con dicha informacion
     * Cada linea del archivo contiene el numero de la provincia y los 12 numeros
     * que corresponden a las lluvias mensuales.
     * Cada dato esta separado por punto y coma.
     * Escribir una aplicacion que muestre un listado de las provincias en orden de
     * la cantidad de lluvia total anual de la mas baja a la mas alta
     */

     public  void generateProvinces() throws IOException {
         File file = new File("provinces.txt");
         RandomAccessFile raf = new RandomAccessFile(file, "rw");
         int[] codes = new int[23];
         for (int i = 0; i < 23; i++) {
             codes[i] = (i+1);
         }
         raf.seek(0);
         for (int i = 0; i < 23; i++) {
             raf.writeInt(codes[i]);
             for (int j = 0; j < 12; j++) {
                 raf.writeInt(randomNumberInRange(50,121));
             }

         }
         raf.close();

     }
    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }

     public  void showSortedProvPerRain() throws IOException {
         OrderedDynamicList<Province> list = new OrderedDynamicList<Province>();
         Province[] provinces = readProvinceFile();
         for (int i = 0; i < provinces.length; i++) {
             list.add(provinces[i]);
         }
         for (int i = 0; i < list.size(); i++) {
             list.goTo(i);
             System.out.println(list.getActual().toString());
         }
     }


     public  Province[] readProvinceFile() throws IOException {
         Province[] provinces = new Province[23];
         File file = new File("provinces.txt");
         RandomAccessFile raf = new RandomAccessFile(file, "rw");
         int regLength = 13*4;
         int regCant = (int) (raf.length()/regLength);
         raf.seek(0);
         for (int i = 0; i < regCant; i++) {
             int provCode = raf.readInt();
             int rainSum = 0;
             for (int j = 0; j < 12; j++) {
                 rainSum+=raf.readInt();
             }
             provinces[i] = new Province(provCode, rainSum);

         }
         raf.close();
         return provinces;
     }





    /**
     * El departamento de estadística de una empresa telefónica recibe un archivo de texto con las
     * llamadas que se hicieron al exterior durante un determinado mes. Cada línea del archivo contiene
     * un número de 1 a 50 que representa un país y el tiempo en minutos y segundos de la llamada.
     * Cada dato está separado,por punto y coma. Se pide:
        a. La cantidad de llamadas que se hicieron a cada país
        b. Cuantas llamadas duraron más de 7 minutos.
     */

    public void generateCalls() throws IOException {
        File file = new File("calls.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int[] codes = new int[50];
        /*for (int i = 0; i < 50; i++) {
            codes[i] = (i+1);
        }*/
        raf.seek(0);
        for (int i = 0; i < 100000; i++) {
            if(i%1000==0) System.out.println("...");
            raf.writeInt(randomNumberInRange(1,51));
            raf.writeInt(randomNumberInRange(1, 60));
            raf.writeInt(randomNumberInRange(1, 60));
        }
        raf.close();

    }

    public  void callsLongerThan7min() throws IOException {
        int counter = 0;
        Call[] calls = readCalls();
        for (int i = 0; i < calls.length; i++) {
            if(calls[i].getMinutes() > 7) counter++;
        }
        System.out.println("Calls longer than 7min: " + counter);
    }

    public  void callsPerCountry() throws IOException {
        Call[] calls = readCalls();
        int[] codes = new int[50];
        for (int i = 0; i < calls.length; i++) {
            codes[calls[i].getCountryCode()-1]++;
        }
        for (int i = 0; i < codes.length; i++) {
            System.out.println("Country +" + (i+1)+": " + codes[i] + " calls.");
        }

    }


    public  Call[] readCalls() throws IOException {
        File file = new File("calls.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int regLength = 4+4+4;
        int regCant = (int) (raf.length()/regLength);
        Call[] calls = new Call[regCant];
        raf.seek(0);
        for (int i = 0; i < regCant; i++) {
            calls[i] = new Call(raf.readInt(), raf.readInt(),raf.readInt());
        }
        raf.close();
        return calls;

    }



}
