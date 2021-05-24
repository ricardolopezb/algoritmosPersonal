package lists;

public class ListApi<T extends Comparable<T>>{
    public boolean search(DynamicList<T> list, Comparable<T> elem){
        list.goTo(0);
        for (int i = 0; i < list.size(); i++) {
            if(elem.compareTo(list.getActual()) == 0){
                return true;
            }
            if(!list.listEnd()) {
                list.goNext();
            }
        }
        return false;
    }
    public void printList(DynamicList<T> list){
        list.goTo(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getActual());
            if(!list.listEnd()) {
                list.goNext();
            }
        }
    }

}
