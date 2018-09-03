// https://leetcode.com/problems/longest-palindromic-subsequence
public class Solution {
    // dp[i][j] = longest palindromic subsequence of s[i:j+1]
    // dp[i][j] = 2 + dp[i+1][j-1] if s[i] == s[j] else max(dp[i][j-1], dp[i+1][j])
    // Note the tricky traversal order to ensure sub-problems are solved first
    // O(n^2) runtime, O(n) space
    public int longestPalindromeSubseq(String s) {
        // dp_1 = dp[i+1]
        int[] dp_1 = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            int[] dp = new int[s.length()];
            dp[i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + dp_1[j-1];
                } else {
                    dp[j] = Math.max(dp_1[j], dp[j-1]);
                }
            }
            dp_1 = dp;
        }
        return dp_1[s.length()-1];
    }
}
