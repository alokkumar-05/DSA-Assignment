import java.util.Arrays;

class EggDropping {

    /*-----------------------------------------------------------
     * 1. DP Memoization (Top-Down)
     *-----------------------------------------------------------*/
    public int eggDropMemo(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(e, f, dp);
    }

    private int solve(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;

        if (dp[e][f] != -1) return dp[e][f];

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k <= f; k++) {
            int breakCase = solve(e - 1, k - 1, dp);
            int noBreakCase = solve(e, f - k, dp);
            int worst = 1 + Math.max(breakCase, noBreakCase);

            ans = Math.min(ans, worst);
        }
        return dp[e][f] = ans;
    }

    /*-----------------------------------------------------------
     * 2. DP Tabulation (Bottom-Up)
     *-----------------------------------------------------------*/
    public int eggDropTab(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        for (int i = 1; i <= e; i++) {
            dp[i][0] = 0; 
            dp[i][1] = 1;
        }

        for (int j = 1; j <= f; j++)
            dp[1][j] = j;

        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k <= j; k++) {
                    int worst = 1 + Math.max(dp[i - 1][k - 1],
                                             dp[i][j - k]);
                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }
        return dp[e][f];
    }
}

/*
---------------------------------------------------------
Time Complexity:
Memoization: O(e * f²)
Tabulation : O(e * f²)

Space Complexity:
O(e * f)
---------------------------------------------------------
*/
