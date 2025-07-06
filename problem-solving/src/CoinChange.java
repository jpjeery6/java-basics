public class CoinChange {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.coinChange(new int[]{1,2,5}, 11);
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int ans = solve(coins, amount);
            return ans == Integer.MAX_VALUE? -1: ans;
        }

        private int solve(int[] coins, int amt) {
            if (amt == 0) return 0;
            if (amt < 0) return Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            int ans;
            for (int c: coins) {
                ans = 1 + solve(coins, amt - c);
                min = Math.min(min, ans);
            }
            return min;
        }
    }
}
