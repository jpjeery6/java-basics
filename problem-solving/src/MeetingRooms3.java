import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms3 {

    public static void main(String[] args) {
//            int[][] meets = {{0,10},{1,5},{2,7},{3,4}};
//            int n = 2;
        int[][] meets = {{18,19},{3,12},{17,19},{2,13},{7,10}};
        int n = 4;
        mostBooked(n, meets);
    }


    public static int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        int i = 0;
        Arrays.sort(meetings, (p, q) -> Integer.compare(p[0], q[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p,q) -> {
            int res = Integer.compare(p[2], q[2]);
            if (res == 0) return Integer.compare(p[0], q[0]);
            else return res;
        });

        for (int[] m: meetings) {
            if (minHeap.isEmpty()) {
                minHeap.add(new int[]{i, m[0], m[1]});
                ans[i]++;
                i++;
            } else {
                if (minHeap.peek()[2] <= m[0]) {
                    int[] popped = minHeap.poll();
                    int room = popped[0];
                    minHeap.add(new int[] {room, m[0], m[1] + popped[2]});
                    ans[room]++;
                } else {
                    if (minHeap.size() < n) {
                        minHeap.add(new int[]{i, m[0], m[1]});
                        ans[i]++;
                        i++;
                    } else {
                        int[] popped = minHeap.poll();
                        int room = popped[0];
                        minHeap.add(new int[] {room, m[0], m[1] + popped[2]});
                        ans[room]++;
                    }
                }
            }
        }

        int max = -1;
        int maxRoom = -1;
        for (int j=0; j< ans.length; j++) {
            if (ans[j] > max) {
                max = ans[j];
                maxRoom = j;
            }
        }
        return maxRoom;
    }

}
