class JumpGame2 {

    /*-----------------------------------------------------------
     * Greedy (Optimal Solution)
     *-----------------------------------------------------------*/
    public int jump(int[] nums) {
        int jumps = 0, end = 0, far = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);

            if (i == end) {
                jumps++;
                end = far;
            }
        }
        return jumps;
    }
}

/*
---------------------------------------------------------
Logic Summary:
far → max reachable
end → boundary of current jump
When i == end → we must jump
---------------------------------------------------------
Time: O(n)
Space: O(1)
---------------------------------------------------------
*/
