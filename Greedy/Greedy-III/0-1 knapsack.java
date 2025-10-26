 class KnapsackOptimized {

    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;           // Number of items
        int[] dp = new int[W + 1];    // DP array for max value for each weight

        // Loop over each item
        for (int i = 0; i < n; i++) {
            // Traverse from high to low to avoid overwriting previous values
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }

        return dp[W]; // Maximum value achievable
    }
}