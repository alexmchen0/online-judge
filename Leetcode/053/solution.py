# https://leetcode.com/problems/maximum-subarray/description/
class Solution:
    # dp[i] = The maximum sum of a subarray containing nums[i]
    # dp[i] = max(nums[i], nums[i] + dp[i-1])
    # Need to find max over all, not just look at dp[n - 1];
    # O(n) time, O(1) space
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        cur_sum = nums[0]
        max_sum = cur_sum
        for i in range(1, len(nums)):
            cur_sum = max(nums[i], cur_sum + nums[i])
            max_sum = max(max_sum, cur_sum)
        return max_sum
