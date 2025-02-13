import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedular {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char t: tasks) {
            map.putIfAbsent(t, 0);
            map.put(t, map.get(t)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p, q) -> Integer.compare(q,p));
        Queue<int[]> q = new LinkedList<>();
        for (char c: map.keySet()) {
            maxHeap.add(map.get(c));
        }

        int cycle = 1;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && q.peek()[1] == cycle) {
                maxHeap.add(q.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                if (maxHeap.peek() == 1)
                    maxHeap.poll();
                else
                    q.add(new int[]{maxHeap.poll()-1, cycle + n+1});
            }
            cycle++;
        }
        return cycle;
    }

}
