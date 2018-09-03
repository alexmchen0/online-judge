# https://leetcode.com/problems/longest-palindromic-subsequence
class Solution(object):
    # dp[i][j] = longest palindromic subsequence of s[i:j+1]
    # dp[i][j] = 2 + dp[i+1][j-1] if s[i] == s[j] else max(dp[i][j-1], dp[i+1][j])
    # Note the tricky traversal order to ensure sub-problems are solved first
    # O(n^2) runtime, O(n) space
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        # dp_1 = dp[i+1]
        dp_1 = [0 for _ in range(len(s))]
        for i in reversed(range(0, len(s))):
            dp = [0 for _ in range(len(s))]
            dp[i] = 1
            for j in range(i+1, len(s)):
                dp[j] = 2 + dp_1[j-1] if s[i] == s[j] else max(dp[j-1], dp_1[j])
            dp_1 = dp
        return dp_1[len(s) - 1]
