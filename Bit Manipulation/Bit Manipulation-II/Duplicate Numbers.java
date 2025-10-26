
/*
Problem Name: Find the Duplicate Number
Platform: LeetCode 
Link: https://leetcode.com/problems/find-the-duplicate-number/
*/
 class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int duplicate = 0;

        for (int bit = 0; bit < 32; bit++) {
            int mask = 1 << bit;
            int countNums = 0, countRange = 0;

            // Count set bits in nums
            for (int num : nums) if ((num & mask) != 0) countNums++;

            // Count set bits in 1..n
            for (int i = 1; i <= n; i++) if ((i & mask) != 0) countRange++;

            if (countNums > countRange) duplicate |= mask; // set bit in duplicate
        }

        return duplicate;
    }

}

/*
---------------------------------
Logic:
1. Count set bits at each position in array and in 1..n.
2. If array count > range count → bit is set in duplicate.
3. Combine bits to get duplicate number.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
