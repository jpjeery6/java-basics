public class BuySellStock2 {

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        System.out.println(maxProfit(p));
    }



    public static int maxProfit(int[] prices) {
        return solve(0, prices);
    }

    public static int solve(int i, int[] p) {
        int n = p.length;
        if (i == n-1) return 0;
        int b = i;
        int s = i+1;

        int max=0, pf = 0;
        int ans = 0;
        while (s<n) {
            if (p[s] < p[b]) {
                b = s;
            } else if (p[s] > p[b]) {
                // choice 1
                pf = p[s] - p[b];
                ans = pf + solve(s+1, p);
                // choice 2
                max = Math.max(pf, max);
            }
            s++;
        }
        return Math.max(max, ans);
    }

}
