package application;

import java.util.*;

public class MyArrayList<T> implements List<T>, RandomAccess {

    public static final int DEFAULT_LENGTH = 10;

    private int size = 0;
    private T[] array;

    public MyArrayList()
    {
        this(DEFAULT_LENGTH);
    }

    public MyArrayList (int length)
    {
        array = (T[]) new Object[length];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Iterator<T> iterator() {
        T[] copy = Arrays.copyOf(array, size);

        return Arrays.asList(copy).iterator();
    }

    public Object[] toArray() {
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            T1[] a1 = (T1[]) new Object[size];
            a = a1;
        }
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) return i;
        }

        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o)) return i;
        }
        return -1;
    }

    public boolean add(T t) {
        try {
            if (size >= array.length) increase();
            array[size++] = t;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void add(int index, T element) {
        checkIndex(index);

        try {
            if (size >= array.length) increase();
            T[] newArray = (T[]) new Object[array.length];
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = element;
            System.arraycopy(array, index, newArray, index + 1, array.length - index - 1);
            array = newArray;
            size++;
        } catch (Exception ex) {

        }
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
        for (T element: c) {
            result &= add(element);
        }
        return result;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        int i = index;
        try {
            for (T element : c) {
                add(i++, element);
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public T set(int index, T element) {
        checkIndex(index);
        T ret = array[index];
        array[index] = element;
        return ret;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        checkIndex(index);
        T[] newArray = (T[]) new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, index);
        T ret = array[index];
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
        size--;
        return ret;
    }

    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (Object element: c) {
            result &= remove(element);
        }
        return result;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object element: c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        size = 0;
        array = (T[]) new Object[DEFAULT_LENGTH];
    }

    public T get(int index) {
        checkIndex(index);

        return array[index];
    }

    public ListIterator<T> listIterator() {
        T[] copy = Arrays.copyOf(array, size);

        return Arrays.asList(copy).listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        T[] copy = Arrays.copyOf(array, size);

        return Arrays.asList(copy).listIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        if (fromIndex > toIndex) throw new IndexOutOfBoundsException();

        T[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
        return Arrays.asList(copy);
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    private void increase()
    {
        int incLength = array.length / 2 * 3 + 1;
        T[] incArray = (T[]) new Object[incLength];
        System.arraycopy(array, 0, incArray, 0, array.length);
        array = incArray;
    }
}
