// https://leetcode.com/problems/maximum-subarray/description/
class Solution {
    // dp[i] = The maximum sum of a subarray containing nums[i]
    // dp[i] = max(nums[i], nums[i] + dp[i-1])
    // Need to find max over all, not just look at dp[n - 1];
    // O(n) time, O(1) space
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int curSum = nums[0];
        int maxSum = curSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
