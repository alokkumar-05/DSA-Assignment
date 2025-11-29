import java.util.*;

class CoinChangeMin {

    /*-----------------------------------------------------------
     * 1. Memoization
     *-----------------------------------------------------------*/
    public int coinChangeMemo(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = solve(coins.length - 1, amount, coins, dp);
        return ans >= 1e9 ? -1 : ans;
    }

    private int solve(int i, int target, int[] coins, int[][] dp) {
        if (i == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int) 1e9;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notPick = solve(i - 1, target, coins, dp);
        int pick = (int) 1e9;

        if (coins[i] <= target)
            pick = 1 + solve(i, target - coins[i], coins, dp);

        return dp[i][target] = Math.min(pick, notPick);
    }

    /*-----------------------------------------------------------
     * 2. Tabulation
     *-----------------------------------------------------------*/
    public int coinChangeTab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) dp[0][t] = t / coins[0];
            else dp[0][t] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notPick = dp[i - 1][t];
                int pick = (int) 1e9;

                if (coins[i] <= t) pick = 1 + dp[i][t - coins[i]];

                dp[i][t] = Math.min(pick, notPick);
            }
        }
        return dp[n - 1][amount] >= 1e9 ? -1 : dp[n - 1][amount];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP
     *-----------------------------------------------------------*/
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) prev[t] = t / coins[0];
            else prev[t] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int t = 0; t <= amount; t++) {
                int notPick = prev[t];
                int pick = (int) 1e9;

                if (coins[i] <= t) pick = 1 + curr[t - coins[i]];

                curr[t] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        return prev[amount] >= 1e9 ? -1 : prev[amount];
    }
}

/*
---------------------------------------------------------
Logic Summary:
dp[i][t] = min(pick → 1 + dp[i][t - coin], notPick → dp[i-1][t])
---------------------------------------------------------
Time: O(n * amount)
Space: Tab → O(n * amount), Optimized → O(amount)
---------------------------------------------------------
*/
