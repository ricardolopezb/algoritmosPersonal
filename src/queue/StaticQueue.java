package queue;

import util.IsEmptyException;

public class StaticQueue<T> implements QueueInterface<T> {

    private T[] data = (T[]) new Object[10];
    private int front = 0;
    private int back = 0;

    @Override
    public void enqueue(T x) {
        if(this.back == this.data.length-1){
            this.back = 0;
        }
        if(data[back] != null){
            expandArray();
        }
        data[back] = x;
        this.back++;

    }

    @Override
    public T dequeue() throws IsEmptyException {
        if(isEmpty()) throw new IsEmptyException("The queue has no elements to dequeue");
        T toReturn = data[front];
        data[front] = null;  //es una forma de que el size funcione bien, sino me cuenta los que se les hizo dequeue()
        this.front++;
        return toReturn;
    }

    @Override
    public int size() { //todo try to optimize size algorithm
        /*int size = 0;
        if(back < front){
            size = (data.length-front) + back;

        } else{
            size = back-front;
        }
        return size;*/
        int counter = 0;
        for (T datum : data) {
            if(datum != null){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return back == front;
    }



    private void expandArray() {
        T[] newArray = (T[]) new Object[data.length+10];
        for (int i = front; i < data.length ; i++) {
            if(data[i] == null){
                break;
            }
            newArray[i] = data[i];
        }

        if(back < front){
            for (int i = back; i < front; i++) {
                newArray[i] = data[i];
            }
        }
        this.data = newArray;
        this.front = 0;
        this.back = size();

    }
}
