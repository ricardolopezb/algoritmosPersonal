import lists.DynamicList;
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
        DynamicList<Integer> list = new DynamicList<>();
        int i = 0;
        while(i<27){
            list.insertNext(i);
            i++;
        }

        for (int j = list.size()-10; j < list.size(); j++) {
            list.goTo(j);
            System.out.println(list.getActual().toString());

        }
    }


}
