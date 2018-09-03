// https://leetcode.com/problems/house-robber/description/
class Solution {
    // dp[i] = maximum money by robbing houses 1..i
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    // O(n) runtime, O(1) space
    public int rob(int[] nums) {
        // dp_2 = dp[i-2], dp_1 = dp[i-1]
        int dp_2 = 0, dp_1 = 0;
        for (int num: nums) {
            int dp = Math.max(num + dp_2, dp_1);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp_1;
    }
}
