
/*
Problem Name: Single Number II
Platform: LeetCode / GeeksforGeeks
Link: https://leetcode.com/problems/single-number-ii/
*/

 class SingleNumberII {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int temp = (1 << i);
            int countOne = 0;

            // Count set bits at ith position
            for (int num : nums) {
                if ((num & temp) != 0) countOne++;
            }

            // If count mod 3 = 1, set this bit in result
            if (countOne % 3 == 1) result |= temp;
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Count set bits at each position.
2. If count mod 3 = 1, set that bit in result.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
