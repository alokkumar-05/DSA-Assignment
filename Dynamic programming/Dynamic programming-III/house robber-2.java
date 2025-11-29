import java.util.*;

class HouseRobber2 {

    /*-----------------------------------------------------------
     * Helper: solve normal robber
     *-----------------------------------------------------------*/
    private int robLinear(int[] nums) {
        int prev2 = 0, prev = 0;

        for (int x : nums) {
            int curr = Math.max(prev, prev2 + x);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    /*-----------------------------------------------------------
     * Main function
     *-----------------------------------------------------------*/
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Rob houses 0 to n-2
        int case1 = robLinear(Arrays.copyOfRange(nums, 0, n - 1));

        // Case 2: Rob houses 1 to n-1
        int case2 = robLinear(Arrays.copyOfRange(nums, 1, n));

        return Math.max(case1, case2);
    }
}

/*
---------------------------------------------------------
Logic Summary:
Circular array → cannot rob both 0 and last.
Compute:
1) Rob from 0 to n-2
2) Rob from 1 to n-1
Take the max.
---------------------------------------------------------
Time: O(n)
Space: O(1)
---------------------------------------------------------
*/
