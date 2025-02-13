import java.util.ArrayDeque;
import java.util.Arrays;

public class FirstNegInWindow {

    /**
     * https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1?page=3&sprint=94ade6723438d94ecf0c00c3937dad55&sprint=94ade6723438d94ecf0c00c3937dad55&sortBy=submissions
     *
     * Given an array A[] of size N and a positive integer K,
     * find the first negative integer for each and every window(contiguous subarray) of size K.
     *
     * Input :
     * N = 5
     * A[] = {-8, 2, 3, -6, 10}
     * K = 2
     * Output :
     * -8 0 -6 -6
     * Explanation :
     * First negative integer for each window of size k
     * {-8, 2} = -8
     * {2, 3} = 0 (does not contain a negative integer)
     * {3, -6} = -6
     * {-6, 10} = -6
     */

    public static long[] printFirstNegativeInteger(long[] A, int N, int K)
    {
        ArrayDeque<Integer> q = new ArrayDeque<>(K);
        long[] ans = new long [N-1];
        int j =0;
        for (int i = 0; i< N; i++) {

            if (A[i] < 0) {
                q.offer(i);
            }

            if (i +1 - K ==0) {
                if (q.peekFirst() == null) {
                    ans[j] = 0;
                } else {
                    ans[j] = A[q.peekFirst()];
                }
                j ++;
            }
            if (i+1>K) {
                while (q.peekFirst() != null && i-K >= q.peekFirst()) {
                    q.pop();
                }
                if (q.peekFirst() == null) {
                    ans[j] = 0;
                } else {
                    ans[j] = A[q.peekFirst()];
                }
                j ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // long[] A = {-8, 2, 3, -6, 10};
        // int K = 2;

        long[] A = { 12, -1, -7, 8, -15, 30, 16, 28};
        int K = 3;
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, A.length, K)));
    }


}
