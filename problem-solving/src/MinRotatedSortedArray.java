public class MinRotatedSortedArray {

    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        int m = (l+r)/2;
        if (nums[l]<nums[r]) return nums[l];
        while(l<r) {
            m = (l+r)/2;
            if (m>0 && nums[m-1]>nums[m]) return nums[m];
            if (m< nums.length-1 && nums[m+1]<nums[m]) return nums[m+1];
            // eliminate right
            if (nums[m] < nums[r]) r=m-1;
                // eliminate left
            else if (nums[m] > nums[r]) l=m+1;
        }
        return nums[m];
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        findMin(arr);
    }
}
