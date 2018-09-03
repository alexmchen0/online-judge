# https://leetcode.com/problems/is-subsequence/description/
class Solution(object):
    # Greedy choice: match each char in s with the first matching char in t
    # O(n) runtime, O(1) space
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_idx, t_idx = 0, 0
        while s_idx < len(s):
            if t_idx >= len(t):
                return False
            if s[s_idx] == t[t_idx]:
                s_idx += 1
            t_idx += 1
        return True
