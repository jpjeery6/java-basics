public class median {


    public static void main(String[] args) {
        int[] nums1 = {1,3, 4, 5};
        int[] nums2 = {2,6,7,8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0;
        int r = nums1.length-1;
        int total = nums1.length + nums2.length;
        int totalP = total/2;

        while(l <= r) {
            int m = (l+r)/2 + (l+r)%2;
            int m2 = totalP - m;
            int l1 = m-1 >= 0 && m-1 < nums1.length? nums1[m-1] : Integer.MIN_VALUE;
            int r1 = m >= 0 && m <nums1.length? nums1[m] : Integer.MAX_VALUE;
            int l2 = m2-1 >= 0 && m2-1 < nums2.length ? nums2[m2-1] : Integer.MIN_VALUE;
            int r2 = m2 >= 0 && m2 < nums2.length? nums2[m2] : Integer.MAX_VALUE;

            if (l1<=r2 && l2 <= r1) {
                double ans = 0;
                if (total %2 != 0) { //odd
                    ans = Math.max(l1,l2);
                } else { // even
                    ans = ((double)Math.max(l1,l2) + (double)Math.min(r1,r2))/2;
                }
                return ans;
            } else if(l1 > r2) {
                // eliminate left
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return 0;
    }

}
