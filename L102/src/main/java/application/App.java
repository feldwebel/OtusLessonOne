package application;

import java.util.ArrayList;
import java.util.Date;

public class App {

    protected Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) {
        App app = new App();

        String[] dataSet = {"App"};

        for (String item : dataSet) {
            try {
                app.checkIt(item);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private void checkIt(String item) throws InterruptedException, IllegalAccessException, InstantiationException {
        long before;
        long after;

        int size = 1024 * 1024;
        System.out.println(item);
        runGC();
        before = this.sizeOf();

        Object[] array = new Object[size];
        System.out.println("Array of size: " + array.length + " created");

        for (int i = 0; i < size; i++) {
            array[i] = item.getClass().newInstance();
        }
        runGC();

        after = this.sizeOf();

        System.out.println(before + " " + after);
        System.out.println("Memory spent: " + (after - before));
        System.out.println("divided " + ((after - before) / size));
    }

    private void runGC() throws InterruptedException {
        runtime.gc();
        Thread.sleep(1000);
        runtime.gc();
    }

    private long sizeOf()
    {
        return runtime.totalMemory () - runtime.freeMemory ();
    }
}
