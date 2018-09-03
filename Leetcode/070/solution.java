// https://leetcode.com/problems/climbing-stairs/description/
class Solution {
    // dp[i] = the number of distinct ways to reach the top of i steps
    // Observe that dp[i] = dp[i - 1] + dp[i - 2]
    // O(n) time, O(1) space
    public int climbStairs(int n) {
        // dp_2 = dp[i-2], dp_1 = d[i-1]
        int dp_2 = 1, dp_1 = 1;
        for (int i = 2; i <= n; i++) {
            int dp = dp_1 + dp_2;
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp_1;
    }
}
