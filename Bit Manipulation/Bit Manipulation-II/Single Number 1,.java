
/*
Problem Name: Single Number
Platform: LeetCode / GeeksforGeeks
Link: https://leetcode.com/problems/single-number/
*/

 class SingleNumber {

    public int singleNumber(int[] nums) {
        int single = 0;
        // XOR all elements; duplicates cancel out
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}

/*
---------------------------------
Logic:
1. XOR all numbers; duplicates cancel out (a ^ a = 0)
2. Remaining number is the single number
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
