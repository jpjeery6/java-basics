import java.util.ArrayList;
import java.util.List;

public class ReversePair {
    public static void main(String[] args) {
        // int[] nums = {1,3,2,3,1};
        int[] nums = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
//        [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
        System.out.println(reversePairs(nums));
    }


    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
        // return cnt;
    }

    private static int mergeSort(int[] nums, int l, int r) {
        if (l==r) return 0;
        int mid = l+ (r-l)/2;
        return mergeSort(nums, l, mid)
                + mergeSort(nums, mid+1, r)
                + merge(nums, l, mid, mid+1, r);
    }

    private static int merge(int[] nums, int l1, int r1, int l2, int r2) {
        int i = l1;
        int j = l2;
        int k = j;
        int cnt = 0;
        List<Integer> tmp = new ArrayList<>();
        while(i<=r1 && j<=r2) {
            if (nums[i] > 2* (long)nums[j]) {
                cnt += (r1-i+1);
                j++;
            }
            if (k <=r2 && nums[i] > nums[k]) {
                tmp.add(nums[k]);
                k++;
            } else {
                tmp.add(nums[i]);
                i++;
            }
        }

        while(i<=r1) {
            tmp.add(nums[i]);
            i++;
        }
        while(k<=r2) {
            tmp.add(nums[k]);
            k++;
        }

        for(int it = l1; it<=r2; it++) {
            nums[it] = tmp.get(it-l1);
        }
        return cnt;

    }

}
