import java.util.*;
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subarraySum(new int[] {1,2,3}, 2);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            int sum = 0;
            int c = 0;
            for (int i=0; i< nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    c += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
            return c;
        }
    }
}
