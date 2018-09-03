// https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    // dp_pos[i] = The maximum product of a subarray containing nums[i]
    // dp_neg[i] = The minimum (most negative) product of a subarray containing nums[i]
    // dp_pos[i] = max(nums[i], nums[i] * dp_pos[i-1], nums[i] * dp_neg[i-1])
    // dp_neg[i] = min(nums[i], nums[i] * dp_pos[i-1], nums[i] * dp_neg[i-1])
    // Need to find max over all, not just look at dp[n - 1];
    // O(n) time, O(1) space
    public int maxProduct(int[] nums) {
        // dp_pos_1 = dp_pos[i-1], dp_neg_1 = dp_neg[i-1]
        int dp_pos_1 = nums[0], dp_neg_1 = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int dp_pos = Math.max(num, Math.max(dp_pos_1 * num, dp_neg_1 * num));
            int dp_neg = Math.min(num, Math.min(dp_pos_1 * num, dp_neg_1 * num));
            maxProd = Math.max(maxProd, dp_pos);
            dp_pos_1 = dp_pos;
            dp_neg_1 = dp_neg;
        }
        return maxProd;
    }
}
