// https://leetcode.com/problems/regular-expression-matching/description/
class Solution {
    // dp[i][j] = if s[:i] matches p[:j] (s[:0] and p[:0] are empty strings)
    // Without regex operators, dp[i+1][j+1] = dp[i][j] && s[i] == p[j]
    // How does regex operators affect the relation to subproblems?
    // - see lines 24(.) and 26-29(*) for answer
    // Let n = s.length() and m = p.length()
    // O(m*n) runtime, O(m*n) space (can be reduced to O(n))
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Initialize edges
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            int dj = j + 1; // dj indexes into dp table while j indexes into p
            dp[0][dj] = p.charAt(i) == '*' && dp[0][dj - 2])
        }

        // Fill in rest of dp table
        for (int i = 0; i < s.length(); i++) {
            int di = i + 1; // di indexes into dp table while i indexes into s
            for (int j = 0; j < p.length(); j++) {
                int dj = j + 1;
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[di][dj] = dp[di-1][dj-1];
                } else if (p.charAt(j) == '*') {
                    boolean isPrevSame = s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.';
                    dp[di][dj] = dp[di][dj-2] || (isPrevSame && dp[di-1][dj]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
