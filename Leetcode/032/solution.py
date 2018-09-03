# https://leetcode.com/problems/longest-valid-parentheses
# See the great solutions here: https://leetcode.com/articles/longest-valid-parentheses/
# Note that DP might not be the best solution for this problem
# For parentheses matching questions, think of the stack.
# Here's my solution: O(n) time, O(n) space.
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = max_len = 0
        dp = [0 for _ in range(len(s)+1)]
        for i in range(1, len(s) + 1):
            if s[i-1] == '(':
                count += 1
            elif count > 0:
                count -= 1
                dp[i] = 2 + dp[i-1];
                dp[i] = dp[i] + dp[i - dp[i]]
                max_len = max(dp[i], max_len)

        return max_len
