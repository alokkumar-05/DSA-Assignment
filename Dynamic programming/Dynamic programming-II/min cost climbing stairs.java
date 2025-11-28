
import java.util.Arrays;

 class Solution {

    /*-----------------------------------------------------------
     * 1. Memoization (Top-Down DP)
     *-----------------------------------------------------------*/
    public int minCostMemo(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, cost, dp);
    }

    private int solve(int i, int[] cost, int[] dp) {
        if (i <= 1) return 0;

        if (dp[i] != -1) return dp[i];

        int one = solve(i - 1, cost, dp) + cost[i - 1];
        int two = solve(i - 2, cost, dp) + cost[i - 2];

        return dp[i] = Math.min(one, two);
    }

    /*-----------------------------------------------------------
     * 2. Tabulation (Bottom-Up DP)
     *-----------------------------------------------------------*/
    public int minCostTab(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP (Best Method)
     *-----------------------------------------------------------*/
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = 0; // dp[i-2]
        int prev = 0;  // dp[i-1]

        for (int i = 2; i <= n; i++) {
            int curr = Math.min(prev + cost[i - 1],
                                prev2 + cost[i - 2]);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

/*
---------------------------------------------------------
Logic Summary:
dp[i] = min(dp[i-1] + cost[i-1],
            dp[i-2] + cost[i-2])
Space optimized by keeping only last 2 values.
---------------------------------------------------------
Complexity:
Time = O(n)
Space:
Memo = O(n)
Tab = O(n)
Space-Opt = O(1)
---------------------------------------------------------
*/
