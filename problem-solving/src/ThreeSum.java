import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <3) return res;

        Arrays.sort(nums);
        int i,j,target;
        for (int k=0; k< nums.length-2; k++) {
            if (k>0 && nums[k-1] == nums[k])
                continue;
            i = k+1;
            j = nums.length-1;
            target = 0 - nums[k];
            while (i < j) {
                if (nums[i] + nums[j] < target || (i>k+1 && nums[i] == nums[i-1]))
                    i++;
                else if (nums[i] + nums[j] > target || (j< nums.length-1 && nums[j] == nums[j+1]))
                    j--;
                else if (nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++;
                    j--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr);
        LinkedHashSet<Character> windowChars = new LinkedHashSet<>();
        windowChars.clear();
    }
}
