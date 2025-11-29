class GoldMine {

    /*-----------------------------------------------------------
     * DP Tabulation (Right → RightUp → RightDown)
     *-----------------------------------------------------------*/
    public int maxGold(int n, int m, int[][] mine) {
        int[][] dp = new int[n][m];

        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {

                int right = (col == m - 1) ? 0 : dp[row][col + 1];
                int rightUp = (row == 0 || col == m - 1) ? 0 : dp[row - 1][col + 1];
                int rightDown = (row == n - 1 || col == m - 1) ? 0 : dp[row + 1][col + 1];

                dp[row][col] = mine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}

/*
---------------------------------------------------------
Logic Summary:
From each cell → 3 choices:
right, right-up, right-down
dp[i][j] = gold[i][j] + max of the 3 paths
---------------------------------------------------------
Time: O(n*m)
Space: O(n*m)
---------------------------------------------------------
*/
