import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for (int i=0; i <= n; i++) {
                for (String w: wordDict) {
                    if(dp[i]
                            && w.length() <= n-i) {
                        String s1 = s.substring(0,i) + w;
                        String s2 = s.substring(0, i + w.length());
                        if (s1.equals(s2))
                            dp[i+w.length()] = true;
                    }
                }
            }
            return dp[n];
        }
    }
}
