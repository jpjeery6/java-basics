import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(2);

        int x = 100;

        ArrayList<Integer> temp = new ArrayList<>(heap);
    }

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int m;
        // base condition
        while (l<=h) {
            m = (l+h)/2;

            if (nums[m] > nums [l]) l=m+1; else h = m-1;

            if  (m + 1 < nums.length) if (nums[m] > nums[m+1]) return nums[m+1];
            if (m - 1 >=0) if (nums[m] < nums[m - 1]) return nums[m-1];
        }
        return 1;
    }

    public static void maxProfit(int[] prices) {

        // buy at local minima
        // sell at local maxima
        int lmin_id = -1;
        int lmin = Integer.MAX_VALUE;

        // find local minima
        for (int i = 0; i + 1 < prices.length; i++) {
            if (prices[i] < prices[i + 1] && prices[i] < lmin) {

            }
                lmin_id = i;
            lmin = prices[i];
        }
    }
}
