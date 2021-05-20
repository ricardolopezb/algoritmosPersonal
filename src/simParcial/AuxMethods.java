package simParcial;

import java.util.Random;

public class AuxMethods {

    public static String newNombre(){
        return "AAAA";
    }

    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }



}
