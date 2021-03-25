package stack;

import util.IsEmptyException;

public class StaticStack<T> implements StackInterface<T> {

    T[] data = (T[])new Object[10];
    int top = 0;

    @Override
    public void stack(T x) {
        if(top == data.length-1){
            expandArray();
        }
        data[top] = x;
        top++;

    }

    @Override
    public void pop() throws IsEmptyException {
        if(top == 0) throw new IsEmptyException("The stack has no elements to pop");
        top--;

    }

    @Override
    public T peek() {
        if(top == 0) return null;
        return data[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void empty() {
        this.data = (T[]) new Object[10];
        this.top = 0;

    }

    private void expandArray(){
        T[] newArray = (T[]) new Object[data.length+10];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        this.data = newArray;
    }

}
