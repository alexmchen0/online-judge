# https://leetcode.com/problems/house-robber/
class Solution(object):
    # dp[i] = maximum money by robbing houses 1..i
    # dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    # O(n) runtime, O(1) space
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # dp_2 = dp[i-2], dp_1 = dp[i-1]
        dp_2 = dp_1 = 0;
        for num in nums:
            dp = max(dp_1, dp_2 + num)
            dp_1, dp_2 = dp, dp_1
        return dp_1
