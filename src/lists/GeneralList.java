package lists;

public interface GeneralList<T> {
    void remove();
    void goNext();
    void goPrev();
    void goTo(int n);
    T getActual();
    int getActualPosition();
    int size();
    boolean isVoid();
    boolean listEnd();
    boolean listStart();
    GeneralList<T> clone();
}
