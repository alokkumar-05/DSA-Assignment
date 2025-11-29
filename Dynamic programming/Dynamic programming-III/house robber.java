import java.util.*;

class HouseRobber {

    /*-----------------------------------------------------------
     * 1. DP Memoization (Top-Down)
     *-----------------------------------------------------------*/
    public int robMemo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n - 1, dp);
    }

    private int solve(int[] nums, int idx, int[] dp) {
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + solve(nums, idx - 2, dp);
        int skip = solve(nums, idx - 1, dp);

        return dp[idx] = Math.max(pick, skip);
    }

    /*-----------------------------------------------------------
     * 2. DP Tabulation (Bottom-Up)
     *-----------------------------------------------------------*/
    public int robTab(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized DP
     *-----------------------------------------------------------*/
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev = 0;

        for (int val : nums) {
            int curr = Math.max(prev, prev2 + val);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

/*
---------------------------------------------------------
Logic Summary:
Pick or Skip the current house.
dp[i] = max(nums[i] + dp[i-2], dp[i-1])
---------------------------------------------------------
Time: O(n)
Space: Memo→O(n), Tab→O(n), Optimized→O(1)
---------------------------------------------------------
*/
