public class SubsetSum {

    /**
     *
     * Given a set of non-negative integers and a value sum,
     * the task is to check if there is a subset of the given set whose sum is equal to the given sum.
     * {1,5,0,1,4,2}
     * 3
     * true/false
     */


    public static void main(String[] args) {
        // int[] arr = {1,5,0,1,4,2};
        int[] arr = {};
        int sum = 4;
        System.out.println(findSum(arr, arr.length, sum));
    }

    static boolean findSum(int[]arr, int n, int sum) { // O(2 * n) approach
        if (n == 0)
            return false;
        int remSum = sum - arr[n-1];

        if (remSum > 0)
            return findSum(arr, n-1, remSum);
        else if (remSum == 0)
            return true;
        else
            return findSum(arr, n-1, sum);
    }


}
