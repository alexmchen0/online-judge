# https://leetcode.com/problems/decode-ways/description/
class Solution:
    # dp[i] = number of ways to decode s[:i+1]
    # either dp[i] = dp[i-1] or dp[i] = dp[i-1] + dp[i-2] (Understand this)
    # O(n) runtime, O(1) space
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or s[0] == '0':
            return 0

        # dp_2 = dp[i-2], dp_1 = d[i-1]
        dp_2 = dp_1 = 1
        for i in range(1, len(s)):
            dp = 0

            if s[i] > '0':
                dp += dp_1 # valid one-digit, build on dp[i-1]
            elif s[i-1] != '1' and s[i-1] != '2':
                return 0 # found a 0 that's not part of a two-digit, invalid

            if s[i-1] == '1' or s[i-1] == '2' and s[i] <= '6':
                dp += dp_2 # valid two-digit, build on dp[i-2]

            dp_2, dp_1 = dp_1, dp
        return dp_1
