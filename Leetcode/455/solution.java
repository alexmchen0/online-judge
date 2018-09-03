// https://leetcode.com/problems/assign-cookies/description/
class Solution {
    // O(nlogn) runtime, O(1) space
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx = 0, sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                gIdx++;
            }
            sIdx++;
        }
        return gIdx;
    }
}
