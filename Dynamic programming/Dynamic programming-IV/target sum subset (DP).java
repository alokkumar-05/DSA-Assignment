class TargetSubset {

    /*-----------------------------------------------------------
     * Tabulation DP
     *-----------------------------------------------------------*/
    public boolean subsetSum(int[] nums, int target) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {

                boolean notPick = dp[i - 1][sum];
                boolean pick = false;

                if (nums[i - 1] <= sum)
                    pick = dp[i - 1][sum - nums[i - 1]];

                dp[i][sum] = pick || notPick;
            }
        }

        return dp[n][target];
    }
}

/*
---------------------------------------------------------
Logic Summary:
dp[i][sum] = pick OR notPick
---------------------------------------------------------
Time: O(n * target)
Space: O(n * target)
---------------------------------------------------------
*/
