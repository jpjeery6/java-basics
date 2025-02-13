import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {11, 12, 8, 9, 7};
        maxSlidingWindow(arr, 3);
    }

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>( (p,q) -> Integer.compare(q.val, p.val));
        int[] res = new int[nums.length - k +1];
        int i = 0;
        int itr = 0;
        for (int j=0; j< nums.length; j++) {
            heap.add(new Pair(nums[j], j));
            if(heap.size() == k) {
                res[itr] = heap.peek().val;
            }
            else if (heap.size() > k) {
                heap.remove(new Pair(nums[i], i));
                i++;
                res[itr] = heap.peek().val;
            }
        }
        return res;

    }


}
