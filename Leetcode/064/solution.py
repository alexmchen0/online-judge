# https://leetcode.com/problems/minimum-path-sum/description/
class Solution:
    # dp[r][c] = the minimum path sum to point (r,c) on grid
    # Generally, dp[r][c] = min(dp[r][c-1], dp[r-1][c]) + grid[r][c]
    # O(m*n) time, O(m*n) space (can be reduced to O(n) space)
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        nrows = len(grid)
        ncols = len(grid[0])
        dp = [[None for col in row] for row in grid]
        for r in range(nrows):
            for c in range(ncols):
                g = grid[r][c]
                if r == 0 and c == 0:
                    dp[r][c] = g
                elif r == 0:
                    dp[r][c] = dp[r][c-1] + g
                elif c == 0:
                    dp[r][c] = dp[r-1][c] + g
                else:
                    dp[r][c] = min(dp[r-1][c], dp[r][c-1]) + g
        return dp[nrows-1][ncols-1]
