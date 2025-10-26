
/*
Problem Name: Missing Number
Platform: LeetCode / GeeksforGeeks
Link: https://leetcode.com/problems/missing-number/
*/

 class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int num : nums) xor ^= num; // XOR all numbers in array
        for (int i = 0; i <= n; i++) xor ^= i; // XOR 0 to n

        return xor; // missing number
    }
}

/*
---------------------------------
Logic:
1. XOR all array elements and numbers 0 to n.
2. Remaining value is the missing number.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
