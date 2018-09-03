// https://leetcode.com/problems/minimum-path-sum/description/
class Solution {
    // dp[r][c] = the minimum path sum to point (r,c) on grid
    // Generally, dp[r][c] = min(dp[r][c-1], dp[r-1][c]) + grid[r][c]
    // O(m*n) time, O(m*n) space (can be reduced to O(n) space)
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        // Initialize edges
        dp[0][0] = grid[0][0];
        for (int r = 1; r < grid.length; r++) {
            dp[r][0] = grid[r][0] + dp[r-1][0];
        }
        for (int c = 1; c < grid[0].length; c++) {
            dp[0][c] = grid[0][c] + dp[0][c-1];
        }

        // Fill in rest of table
        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                dp[r][c] = Math.min(dp[r][c-1], dp[r-1][c]) + grid[r][c];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
