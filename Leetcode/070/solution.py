# https://leetcode.com/problems/climbing-stairs/description/
class Solution:
    # dp[i] = the number of distinct ways to reach the top of i steps
    # Observe that dp[i] = dp[i - 1] + dp[i - 2]
    # O(n) time, O(1) space
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        # dp_2 = dp[i-2], dp_1 = d[i-1]
        dp_2 = dp_1 = 1
        for _ in range(2, n+1):
            dp_2, dp_1 = dp_1, dp_2 + dp_1
        return dp_1
