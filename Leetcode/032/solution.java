// https://leetcode.com/problems/longest-valid-parentheses
// See the great solutions here: https://leetcode.com/articles/longest-valid-parentheses/
// Note that DP might not be the best solution for this problem
// For parentheses matching questions, think of the stack.
// Here's my solution: O(n) time, O(n) space.
class Solution {
    public int longestValidParentheses(String s) {
        int count = 0, maxLength = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '(') {
                count++;
            } else if (count > 0) {
                count--;
                dp[i] = 2 + dp[i-1];
                dp[i] = dp[i] + dp[i - dp[i]];
                maxLength = Math.max(dp[i], maxLength);
            }
        }
        return maxLength;
    }
}
