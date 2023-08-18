import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyArrayListTest {


    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertEquals(1, list.size());
        assertEquals(1, (int)list.get(0));
    }

    @Test
    public void testAddByIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 42);
        assertEquals(1, list.size());
        assertEquals(42, (int)list.get(0));
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(2, (int)list.get(0));
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort();
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
        assertEquals(3, (int)list.get(2));
    }


}
