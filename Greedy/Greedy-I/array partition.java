
/*
Problem Name: Array Partition I
Platform: LeetCode
Link: https://leetcode.com/problems/array-partition-i/
*/

import java.util.Arrays;

 class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // Sort array
        int sum = 0;

        // Take every alternate element (smaller one in each pair)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

}

/*
---------------------------------
Logic:
1. Sort array and pair consecutive elements.
2. Sum all elements at even indices.
---------------------------------
Complexity:
- Time: O(n log n)
- Space: O(1)
*/
