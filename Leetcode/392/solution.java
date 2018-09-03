// https://leetcode.com/problems/is-subsequence/description/s
class Solution {
    // Greedy choice: match each char in s with the first matching char in t
    // O(n) runtime, O(1) space
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        while (sIdx < s.length()) {
            if (tIdx >= t.length()) {
                return false;
            }
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx ++;
        }
        return true;
    }
}
