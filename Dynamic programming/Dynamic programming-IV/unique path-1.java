import java.util.*;

class UniquePaths {

    /*-----------------------------------------------------------
     * 1. Memoization
     *-----------------------------------------------------------*/
    public int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(m - 1, n - 1, dp);
    }

    private int solve(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(i - 1, j, dp) + solve(i, j - 1, dp);
    }

    /*-----------------------------------------------------------
     * 2. Tabulation
     *-----------------------------------------------------------*/
    public int uniquePathsTab(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP
     *-----------------------------------------------------------*/
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
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
dp[i][j] = dp[i-1][j] + dp[i][j-1]
---------------------------------------------------------
Time: O(m*n)
Space: Memo->O(m*n), Tab->O(m*n), Optimized->O(n)
---------------------------------------------------------
*/
