public class StaticQueue<T> implements Queue<T> {

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
    public T dequeue() {
        T toReturn = data[front];
        this.front++;
        return toReturn;
    }

    @Override
    public int size() {
        int size = 0;
        if(back < front){
            size = (data.length-front) + back;

        } else{
            size = back-front;
        }



        return size;
    }

    @Override
    public boolean isEmpty() {
        return back == front;
    }

    private void expandArray() {
        T[] newArray = (T[]) new Object[data.length+10];
        int globalPos = 0;
        for (int i = front; i < data.length-front ; i++) {
            newArray[globalPos] = data[globalPos];
            globalPos++;
        }
        if(back < front){
            for (int i = back; i < front; i++) {
                newArray[globalPos] = data[globalPos];
                globalPos++;

            }
        } else{
            for (int i = back; i < data.length; i++) {
                newArray[globalPos] = data[globalPos];
                globalPos++;
            }
        }
        data = newArray;

    }
}
