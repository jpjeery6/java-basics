
/**
 *
 *
 * Given an array Arr[] of N integers.
 * Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 *
 * {1,-5,8,3,0,-2,8}
 *
 *
 * {-1,-2,-3}
 * -1
 *
 * {1,2,3,-2,-5,4,5}
 * 9
 *
 */

public class MaxSumSubarray {

    public static void main(String[] args) {
        // int[] arr = {1,2,3,-2,-5,4,5};
        int [] arr = {-1,-2,-3};
        int maxSum = arr[0];
        int currSum = 0;
        for (int i=0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println(maxSum);
    }

    // max sum sub array with start and end index
    static void maxSubArraySum(int[] a, int size)
    {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}