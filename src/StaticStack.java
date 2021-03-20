public class StaticStack<T> implements Stack<T> {

    T[] data = (T[])new Object[10];
    int top = 0;

    @Override
    public void push(T x) {
        if(top == data.length-1){
            expandArray();
        }
        data[top] = x;
        top++;

    }

    @Override
    public void pop() {
        top--;

    }

    @Override
    public T peek() {
        return data[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int size() {
        return top-1;
    }

    private void expandArray(){
        T[] newArray = (T[]) new Object[data.length+10];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        this.data = newArray;
    }

}
