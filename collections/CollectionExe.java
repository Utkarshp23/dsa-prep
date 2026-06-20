import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class CollectionExe {

    public static void main(String[] args) {

        // Drill 1
        Queue<String> que = new LinkedList<>();
        List<String> tickets = Arrays.asList("Login issue", "Payment failed", "App crash");

        for (String ticket : tickets) {
            que.offer(ticket);
        }

        while (!que.isEmpty()) {
            System.out.println("Processing:" + que.poll());
        }

        // Drill 2
        LinkedHashMap<String, String> lmap = new LinkedHashMap<>();
        lmap.put("name", "utkarsh");
        lmap.put("email", "utkarshpawar2332@gmail.com");
        lmap.put("phone", "8975207820");
        lmap.put("city", "Satara");

        items.forEach((key, value) -> System.out.println(key + " : " + value));

        // Drill: 3
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Charlie", 85);
        map.put("Alice", 92);
        map.put("Bob", 78);

        map.forEach((key, value) -> System.out.println(key + " : " + value));

        // Drill 4
        PriorityQueue<String> taskQueue = new PriorityQueue<>();
        taskQueue.add("1-TaskB");
        taskQueue.add("2-TaskC");
        taskQueue.add("3-TaskA");

        while (!taskQueue.isEmpty()) {
            System.out.println("Priority task: " + taskQueue.poll());
        }

    }
}
