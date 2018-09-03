# https://leetcode.com/problems/assign-cookies/description/
class Solution(object):
    # O(nlogn) runtime, O(1) space
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()

        g_idx, s_idx = 0, 0
        while g_idx < len(g) and s_idx < len(s):
            if g[g_idx] <= s[s_idx]:
                g_idx += 1
            s_idx += 1

        return g_idx
