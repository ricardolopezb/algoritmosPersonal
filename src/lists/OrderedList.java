package lists;

import java.io.*;

/**
 * Created by Tomas on 5/13/16.
 */
public class OrderedList<T extends Comparable<T>> extends List<T> {


    /**
     * this method adds an object in the correct position, it does not need to order later.
     */
    public void add(T t) {
        if (size() == 0 || t.compareTo(peekCurrent()) == 0) {
            super.addAfter(t);
            return;
        }
        if(t.compareTo(peekCurrent()) > 0){
            goForward(t);
        } else {
            goBackwards(t);
        }
    }

    private void goForward(T t){
        while(next()){
            if(t.compareTo(peekCurrent()) < 0){
                addBefore(t);
                return;
            }
        }
        addAfter(t);
    }


    /**
     *
     * @requires age > 10
     * @ensures age < 100
     */
    private void goBackwards(T t){
        while(previous()){
            if(t.compareTo(peekCurrent()) > 0){
                addAfter(t);
                return;
            }
        }
        addBefore(t);
    }
}
