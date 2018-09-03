# https://leetcode.com/problems/regular-expression-matching/description/
class Solution:
    # dp[i][j] = if s[:i] matches p[:j] (s[:0] and p[:0] are empty strings)
    # Without regex operators, dp[i+1][j+1] = dp[i][j] && s[i] == p[j]
    # How does regex operators affect the relation to subproblems?
    # - see lines 28(.) and 30-32(*) for answer
    # Let n = len(s) and m = len(p)
    # O(m*n) runtime, O(m*n) space (can be reduced to O(n))
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        dp = [[False for _ in range(len(p) + 1)] for _ in range(len(s) + 1)]

        # Initialize edges
        dp[0][0] = True
        for j in range(len(p)):
            dj = j + 1 # dj indexes into dp table while j indexes into p
            dp[0][dj] = p[j] == "*" and dp[0][dj - 2]

        # Fill in rest of dp table
        for i in range(len(s)):
            di = i + 1 # di indexes into dp table while i indexes into s
            for j in range(len(p)):
                dj = j + 1
                if s[i] == p[j] or p[j] == ".":
                    dp[di][dj] = dp[di-1][dj-1]
                elif p[j] == "*":
                    is_prev_same = p[j-1] == "." or p[j-1] == s[i]
                    dp[di][dj] = dp[di][dj-2] or (is_prev_same and dp[di-1][dj])

        return dp[len(s)][len(p)]
