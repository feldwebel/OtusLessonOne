package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class App {

    protected Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) {
        App app = new App();

        Map<String, Objectivator> dataSet = new HashMap<String, Objectivator>();
        dataSet.put("App", () -> new App()); //23
        dataSet.put("String",() -> new String("")); //28
        dataSet.put("ArrayList", () -> new ArrayList());
        dataSet.put("int[3]", () -> new int[3]); //36
        dataSet.put("int[5]", () -> new int[5]); //44
        dataSet.put("Date", () -> new Date()); //28


        for (Map.Entry<String, Objectivator> item : dataSet.entrySet()) {
            try {
                app.checkIt(item);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private void checkIt(Map.Entry<String, Objectivator> item) throws InterruptedException, IllegalAccessException, InstantiationException {
        long before;
        long after;

        int size = 1024 * 1024;
        System.out.println(item.getKey());
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = item.getValue().getNewObject();
        }
        //runGC();
        before = this.sizeOf();

        array = null;

        runGC();

        after = this.sizeOf();

        System.out.println("Memory spent: " + (before - after));
        System.out.println("divided " + ((before - after) / size));

    }

    private void runGC() throws InterruptedException {
        runtime.gc();
        Thread.sleep(5000);
        runtime.gc();
    }

    private long sizeOf()
    {
        return runtime.totalMemory () - runtime.freeMemory ();
    }

    @FunctionalInterface
    private interface Objectivator{
        Object getNewObject();
    }
}
