# https://leetcode.com/problems/maximum-product-subarray/description/
class Solution:
    # dp_pos[i] = The maximum product of a subarray containing nums[i]
    # dp_neg[i] = The minimum (most negative) product of a subarray containing nums[i]
    # dp_pos[i] = max(nums[i], nums[i] * dp_pos[i-1], nums[i] * dp_neg[i-1])
    # dp_neg[i] = min(nums[i], nums[i] * dp_pos[i-1], nums[i] * dp_neg[i-1])
    # Need to find max over all, not just look at dp[n - 1];
    # O(n) time, O(1) space
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # dp_pos_1 = dp_pos[i-1], dp_neg_1 = dp_neg[i-1]
        dp_pos_1 = dp_neg_1 = max_prod = nums[0]
        for i in range(1, len(nums)):
            num = nums[i]
            dp_pos = max(num, num * dp_pos_1, num * dp_neg_1)
            dp_neg = min(num, num * dp_pos_1, num * dp_neg_1)
            max_prod = max(max_prod, dp_pos)
            dp_pos_1 = dp_pos
            dp_neg_1 = dp_neg
        return max_prod
