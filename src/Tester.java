import lists.DynamicList;
import stack.*;
import queue.*;
import util.IsEmptyException;

public class Tester {
    public static void main(String[] args) {

        DynamicList<Integer> list = new DynamicList<>();

        list.insertNext(5);
        list.insertNext(9);
        list.insertNext(3);
        list.insertPrev(50);
        list.insertNext(6);

        list.goTo(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getActual());
            if(!list.endList())
                list.goNext();
        }
    }

}
