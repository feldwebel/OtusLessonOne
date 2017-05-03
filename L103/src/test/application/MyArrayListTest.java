package application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class MyArrayListTest {

    private static final String S_1 = "String One";
    private static final String S_2 = "String Two";
    private static final String S_3 = "String Three";

    private MyArrayList<String> arr;

    @Before
    public void before() {
        arr = new MyArrayList<>(10);
    }

    @Test
    public void size() throws Exception {
        arr.add(S_1);
        arr.add(S_2);

        Assert.assertEquals(2, arr.size());

    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(arr.isEmpty());
        arr.add(S_1);
        Assert.assertFalse(arr.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        Assert.assertTrue(arr.contains(S_1));
        Assert.assertFalse(arr.contains(S_3));
    }

    @Test
    public void iterator() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        Iterator<String> i = arr.iterator();
        Assert.assertEquals(S_1, i.next());
        Assert.assertEquals(S_2, i.next());

        Assert.assertFalse(i.hasNext());
    }

    @Test
    public void toArray() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        Object[] a = arr.toArray();
        Assert.assertEquals(arr.DEFAULT_LENGTH, a.length);
        Assert.assertEquals(S_1, a[0]);
    }

    @Test
    public void toArray1() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        Object[] a = new Object[10];
        a = arr.toArray(a);
        Assert.assertEquals(S_1, a[0]);
    }

    @Test
    public void indexOf() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        arr.add(S_2);
        Assert.assertEquals(1, arr.indexOf(S_2));
    }

    @Test
    public void lastIndexOf() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        arr.add(S_2);
        Assert.assertEquals(2, arr.lastIndexOf(S_2));
    }

    @Test
    public void add() throws Exception {
        arr.add(S_1);
        arr.add(S_2);
        arr.add(S_3);
        Assert.assertEquals(3, arr.size());
        Assert.assertEquals(S_1, arr.get(0));
    }

    @Test
    public void add1() throws Exception {
    }

    @Test
    public void addAll() throws Exception {
    }

    @Test
    public void addAll1() throws Exception {
    }

    @Test
    public void set() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void remove1() throws Exception {
    }

    @Test
    public void removeAll() throws Exception {
    }

    @Test
    public void containsAll() throws Exception {
    }

    @Test
    public void retainAll() throws Exception {
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void listIterator() throws Exception {
    }

    @Test
    public void listIterator1() throws Exception {
    }

    @Test
    public void subList() throws Exception {
    }

}
