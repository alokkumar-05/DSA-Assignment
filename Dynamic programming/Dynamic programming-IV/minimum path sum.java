import java.util.*;
class MinPathSum {

    /*-----------------------------------------------------------
     * Memoization
     *-----------------------------------------------------------*/
    public int minPathSumMemo(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    private int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return 100000000;

        if (i == 0 && j == 0) return grid[0][0];

        if (dp[i][j] != -1) return dp[i][j];

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left) + grid[i][j];
    }

    /*-----------------------------------------------------------
     * Tabulation
     *-----------------------------------------------------------*/
    public int minPathSumTab(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(up, left) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /*-----------------------------------------------------------
     * Space Optimized
     *-----------------------------------------------------------*/
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                    continue;
                }

                int up = (i > 0) ? prev[j] : Integer.MAX_VALUE;
                int left = (j > 0) ? curr[j - 1] : Integer.MAX_VALUE;

                curr[j] = Math.min(up, left) + grid[i][j];
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}

/*
---------------------------------------------------------
Logic Summary:
dp[i][j] = min(up, left) + grid[i][j]
---------------------------------------------------------
Time: O(m*n)
Space: O(n)
---------------------------------------------------------
*/
