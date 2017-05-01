package application;

import application.MyArrayList;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<String> arr;

    @Before
    public void before() {
        arr = new MyArrayList<>();
    }

    @Test
    public void size() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void contains() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
    }

    @Test
    public void toArray() throws Exception {
    }

    @Test
    public void toArray1() throws Exception {
    }

    @Test
    public void indexOf() throws Exception {
    }

    @Test
    public void lastIndexOf() throws Exception {
    }

    @Test
    public void add() throws Exception {
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

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(MyArrayList.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
