package parcial2017;

import java.util.Random;

public class AuxMethods {
    public static int randomNumberInRange100(){
        Random r = new Random();
        int low = 1;
        int high = 101;
        return r.nextInt(high-low) + low;
    }
    public static Integer[] generateUnsortedIntegerArray(int numElements){
        // Generate an array of integers
        Integer[] randomInts = new Integer[numElements];
        for(int i = 0; i < numElements; ++i){
            randomInts[i] = i;
        }
        // Do the Knuth shuffle
        for(int i = 0; i < numElements; ++i){
            int randomIndex = (int)Math.floor(Math.random() * (i + 1));
            Integer temp = randomInts[i];
            randomInts[i] = randomInts[randomIndex];
            randomInts[randomIndex] = temp;
        }
        return randomInts;
    }
}
