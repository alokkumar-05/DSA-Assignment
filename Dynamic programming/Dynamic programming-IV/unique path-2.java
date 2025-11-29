import  java.util.*;
class UniquePaths2 {

    /*-----------------------------------------------------------
     * Memoization
     *-----------------------------------------------------------*/
    public int uniquePathsWithObstaclesMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(m - 1, n - 1, grid, dp);
    }

    private int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(i - 1, j, grid, dp) + solve(i, j - 1, grid, dp);
    }

    /*-----------------------------------------------------------
     * Tabulation
     *-----------------------------------------------------------*/
    public int uniquePathsWithObstaclesTab(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        if (grid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    /*-----------------------------------------------------------
     * Space Optimized
     *-----------------------------------------------------------*/
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }

                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? curr[j - 1] : 0;

                curr[j] = up + left;
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}

/*
---------------------------------------------------------
Logic Summary:
If obstacle → dp=0
Else dp = up + left
---------------------------------------------------------
Time: O(m*n)
Space: O(n)
---------------------------------------------------------
*/
