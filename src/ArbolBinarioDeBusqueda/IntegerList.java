package ArbolBinarioDeBusqueda;

import java.util.Random;

public class IntegerList {

    int[] randoms;

    public IntegerList() {
        this.randoms = new int[1000];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = randomNumberInRange(1,100001);
        }
    }

    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }

    public int size(){
        return randoms.length;
    }

    public int[] list() {
        return randoms;
    }
}
