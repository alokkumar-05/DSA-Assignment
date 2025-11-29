import java.util.*;
class CoinChange2 {

    /*-----------------------------------------------------------
     * 1. Memoization
     *-----------------------------------------------------------*/
    public int changeMemo(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, amount, coins, dp);
    }

    private int solve(int i, int target, int[] coins, int[][] dp) {
        if (i == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }
        if (dp[i][target] != -1) return dp[i][target];

        int notPick = solve(i - 1, target, coins, dp);
        int pick = 0;

        if (coins[i] <= target)
            pick = solve(i, target - coins[i], coins, dp);

        return dp[i][target] = pick + notPick;
    }

    /*-----------------------------------------------------------
     * 2. Tabulation
     *-----------------------------------------------------------*/
    public int changeTab(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            dp[0][t] = (t % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notPick = dp[i - 1][t];
                int pick = 0;

                if (coins[i] <= t)
                    pick = dp[i][t - coins[i]];

                dp[i][t] = pick + notPick;
            }
        }
        return dp[n - 1][amount];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP
     *-----------------------------------------------------------*/
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        for (int t = 0; t <= amount; t++) {
            prev[t] = (t % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int t = 0; t <= amount; t++) {
                int notPick = prev[t];
                int pick = 0;

                if (coins[i] <= t)
                    pick = curr[t - coins[i]];

                curr[t] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}

/*
---------------------------------------------------------
Logic Summary:
Ways = pick (same index) + notPick (previous index)
---------------------------------------------------------
Time: O(n * amount)
Space: O(amount)
---------------------------------------------------------
*/
