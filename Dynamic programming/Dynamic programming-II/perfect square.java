
import java.util.*;

 class Solution {

    /*-----------------------------------------------------------
     * 1. Memoization (Top-Down DP)
     *-----------------------------------------------------------*/
    public int numSquaresMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for (int j = 1; j * j <= n; j++) {
            ans = Math.min(ans, 1 + solve(n - j*j, dp));
        }

        return dp[n] = ans;
    }

    /*-----------------------------------------------------------
     * 2. Tabulation (Bottom-Up DP) – Best Approach
     *-----------------------------------------------------------*/
    public int numSquaresTab(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }

}

/*
---------------------------------------------------------
Logic Summary:
- dp[i] = minimum squares to form i
- Check all perfect squares j*j ≤ i
- BFS method treats numbers as graph nodes
---------------------------------------------------------
Complexity:
Time: O(n√n)
Space: O(n)
---------------------------------------------------------
*/
