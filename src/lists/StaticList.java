package lists;

public class StaticList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int window;
    private int size;
    private final int capacity;
    public StaticList() {
        this(DEFAULT_CAPACITY);
    }
    public StaticList(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.window = 0;
        this.size = 0;
    }
    private StaticList(int window, int size, int capacity, Object[] data) {
        this.window = window;
        this.size = size;
        this.capacity = capacity;
        this.data = data;
    }
    @Override
    @SuppressWarnings("unchecked")
    public T getActual() {
        if (isVoid()) throw new NullPointerException("The list is empty");
        return (T) data[window];
    }
    @Override
    public int getActualPosition() {
        return window;
    }
    @Override
    public boolean isVoid() {
        return data[0] == null;
    }
    @Override
    public boolean listEnd() {
        return window == data.length - 1;
    }

    @Override
    public boolean listStart() {
        return window == 0;
    }

    @Override
    public GeneralList<T> clone() {
        Object[] cloned = new Object[data.length];
        for (int i = 0; i < data.length; i++) cloned[i] = data[i];
        return new StaticList<T>(window, size, capacity, cloned);
    }
    @Override
    public void insertPrev(T obj) {
        if (size == data.length) enlarge();
        for (int i = data.length - 1; i > window; i--) data[i] = data[i - 1];
        data[window] = obj;
        size++;
    }
    @Override
    public void insertNext(T obj) {
        if (size == data.length) enlarge();
        if (!isVoid()) window++;
        insertPrev(obj);
    }
    @Override
    public void goNext() {
        if (window == size - 1) throw new IndexOutOfBoundsException("Reached the end of the list");
        window++;
    }
    @Override
    public void goPrev() {
        if (window == 0) throw new IndexOutOfBoundsException("Reached the beginning of the list");
        window--;
    }
    @Override
    public void goTo(int index) {
        if (index < 0 || index >= data.length)
            throw new IndexOutOfBoundsException("There is no such index in this list");
        window = index;
    }
    @Override
    public void remove() {
        for (int i = window; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (window >= size) window = size - 1;
    }
    @Override
    public int size() {
        return size;
    }
    private void enlarge() {
        Object[] tempObjects = new Object[data.length + DEFAULT_CAPACITY];
        for (int i = 0; i < data.length; i++) tempObjects[i] = data[i];
        data = tempObjects;
    }
}