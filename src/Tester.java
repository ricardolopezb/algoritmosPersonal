import org.junit.Test;
import org.junit.rules.Stopwatch;
import stack.*;
import queue.*;
import util.IsEmptyException;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Tester {
    int n = 100;

    public static void main(String[] args) {
        LocalTime x = LocalTime.now();
        System.out.println(x.toString());
        int[] y = new int[10000000];
        for (int i = 0; i < y.length; i++) {
            y[i] =2;
        }
        LocalTime z = LocalTime.now();
        System.out.println(z.toString());

        System.out.println(SECONDS.between(x,z));
    }


}
