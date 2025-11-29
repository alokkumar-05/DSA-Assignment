class JumpGame {

    /*-----------------------------------------------------------
     * Greedy (Best Method)
     *-----------------------------------------------------------*/
    public boolean canJump(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}

/*
---------------------------------------------------------
Logic Summary:
Maintain maximum reachable index.
If i > reach → cannot jump.
---------------------------------------------------------
Time: O(n)
Space: O(1)
---------------------------------------------------------
*/
