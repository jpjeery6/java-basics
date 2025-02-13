import java.util.Stack;

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int i=0, j=1;
        int ans=0;
        while(j<prices.length) {
            if (prices[j]-prices[i]<0) {
                i=j;
                j++;
            } else {
                ans = Math.max(ans, prices[j] - prices[i]);
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
    }
}
