
import java.util.Arrays;

 class ClimbingStair {

    /*-----------------------------------------------------------
     * 1. DP Memoization (Top-Down)
     *-----------------------------------------------------------*/
    public int climbStairsMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != -1) return dp[n];

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    /*-----------------------------------------------------------
     * 2. DP Tabulation (Bottom-Up)
     *-----------------------------------------------------------*/
    public int climbStairsTab(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP (Best Method)
     *-----------------------------------------------------------*/
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways(1)
        int prev = 2;  // ways(2)

        for (int i = 3; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

}

/*
---------------------------------------------------------
Logic Summary:
ways(n) = ways(n - 1) + ways(n - 2)
Memoization → recursion + dp
Tabulation → bottom-up dp array
Space Optimized → only last 2 values kept
---------------------------------------------------------
Time Complexity:
All methods: O(n)
Space Complexity:
Memo → O(n)
Tab → O(n)
Space Optimized → O(1)
---------------------------------------------------------
*/
