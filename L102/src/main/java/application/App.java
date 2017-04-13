package application;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        //Runtime runtime = Runtime.getRuntime();
        //RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        int size = 5 * 1024 * 1024;
        Object[] array = new Object[size];
        System.out.println("Array of size: " + array.length + " created");
        //Thread.sleep(10 * 1000);

        int n = 0;
        System.out.println("Starting the loop");
        while (n < Integer.MAX_VALUE) {
            int i = n % size;
            array[i] = new String("zhopa"); //no String pool
            n++;
            if (n % size == 0) {
                long oSize = ObjectSizeCalculator.getObjectSize(array);
                System.out.println("Created " + n + " objects");
                System.out.println(oSize / size);
                //System.out.println(ObjectSizeCalculator.getObjectSize(new gnu.trove.map.hash.TObjectIntHashMap<String>(12000, 0.6f, -1)));
                System.out.println(ObjectSizeCalculator.getObjectSize(new HashMap<String, Integer>(100000)));
                System.out.println(ObjectSizeCalculator.getObjectSize(3));
                System.out.println(ObjectSizeCalculator.getObjectSize(new int[]{1, 2, 3, 4, 5, 6, 7 }));
                System.out.println(ObjectSizeCalculator.getObjectSize(new int[100]));

                System.out.println(Instrument.sizeOf(new int[100]));
            }
        }
    }
}
