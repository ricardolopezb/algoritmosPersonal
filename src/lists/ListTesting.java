package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListTesting {
    @Test
    public void DynamicList(){
        DynamicList<Integer> l1 = new DynamicList<>();
        l1.insertNext(10);
        l1.insertNext(9);
        l1.insertNext(8);
        l1.insertNext(7);
        assertEquals(l1.getActual(),(Integer)7);
        assertEquals(l1.getActualPosition(),3);
        assertFalse(l1.isVoid());
        l1.goPrev();
        assertEquals(l1.getActual(),(Integer)8);
        l1.remove();
        System.out.println(l1.getActual());
    }
    @Test
    public void list(){
        DynamicList<Integer> list = new DynamicList<>();
        list.insertNext(5);
        list.insertNext(9);
        list.insertNext(3);
        assertEquals(list.getActual(),(Integer) 3);
        list.insertPrev(50);
        assertEquals(list.getActual(), (Integer) 50);
        list.goNext();
        list.insertNext(6);
        assertEquals(list.getActual(),(Integer) 6);
        list.goPrev();
        assertEquals(list.getActual(),(Integer) 3);
    }
    @Test
    public void orderedList(){
        OrderedDynamicList<Integer> o = new OrderedDynamicList<>();
        o.add(20);
        o.add(15);
        o.add(18);
        o.add(11);
        o.add(2);
        o.add(36);
        o.add(13);
        ListApi<Integer> api = new ListApi<>();
        api.printList(o);
    }
    @Test
    public void Search(){
        DynamicList<Integer> l1 = new DynamicList<>();
        l1.insertNext(10);
        l1.insertNext(9);
        l1.insertNext(8);
        l1.insertNext(7);
        ListApi<Integer> api = new ListApi<>();
        assertFalse(api.search(l1, 11));
        assertTrue(api.search(l1, 9));
        assertTrue(api.search(l1, 7));
        api.printList(l1);
    }
}
