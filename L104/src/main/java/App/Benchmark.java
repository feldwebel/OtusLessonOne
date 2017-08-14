package App;

import java.util.HashSet;
import java.util.UUID;

public class Benchmark implements BenchmarkMBean {

    private long size = 0;

    public void run(Statistics stat)
    {
        HashSet<String> mySet = new HashSet<>();
        while (true) {
            for (int i = 0; i < size; i++) {
                String current = UUID.randomUUID().toString();
                mySet.add(current);
                if ((i & 0x1) == 1) { //odd items to be removed
                    mySet.remove(current);
                }
            }
            System.out.println("Items setted: " + mySet.size());
            stat.updateStat();
        }
    }

    @Override
    public long getSize()
    {
        return size;
    }

    @Override
    public void setSize(long size)
    {
        this.size = size;
    }
}
