import java.util.HashMap;
import java.util.Map;

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l=0, r = nums.length-1;
        while(l<=r) {
            int m =(l+r)/2;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m]) {
                if (target < nums[m] && target >= nums[l]) r=m-1; else l=m+1;
            } else {
                if (target > nums[m] && target<= nums[r]) l=m+1; else r=m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        search(arr, 8);
    }
}
