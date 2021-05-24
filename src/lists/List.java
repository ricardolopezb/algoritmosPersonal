package lists;

public interface List<L> extends GeneralList<L> {
    void insertNext(L obj);
    void insertPrev(L obj);
}
