package App;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    Map<String, StatItem> stat = new HashMap<>();

    public void updateStat()
    {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollector : garbageCollectorMXBeans) {
            StatItem item;
            if (stat.containsKey(garbageCollector.getName())) {
                item = stat.get(garbageCollector.getName());
                item.setCount(garbageCollector.getCollectionCount());
                item.setTime(garbageCollector.getCollectionTime());
            } else {
                item = new StatItem(garbageCollector.getCollectionTime(), garbageCollector.getCollectionCount());
            }
            stat.put(garbageCollector.getName(), item);
        }

    }

    public void showStat(long millis)
    {
        long overall = System.currentTimeMillis() - millis;

        stat.forEach((gcName, item) -> {
            System.out.println("Garbage Collector: " + gcName);
            System.out.println("Try count: " + item.getCount());
            System.out.println(
                    "Time spent by GC " + item.getTime() + " ms" +
                    " of overall " + overall + " ms " +
                    " about " + (float) item.getTime() / overall + "%"
            );
        });
    }
}
