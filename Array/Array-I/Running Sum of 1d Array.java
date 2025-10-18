package Array;

/*
Problem Name: Running Sum of 1D Array
Problem Link: https://leetcode.com/problems/running-sum-of-1d-array/
*/

class Solution {
    // Function to compute running sum of an array
    public int[] runningSum(int[] nums) {
        int n = nums.length;                // Length of input array
        int[] runningSum = new int[n];      // Array to store running sum
        int sum = 0;                        // Variable to store cumulative sum

        // Traverse the array and compute running sum
        for (int i = 0; i < n; i++) {
            sum += nums[i];                 // Add current element to cumulative sum
            runningSum[i] = sum;            // Store cumulative sum at current index
        }

        return runningSum;                  // Return the running sum array
    }
}

/*
---------------------------------
Logic:
1. Initialize a variable `sum` to 0 to keep track of cumulative sum.
2. Traverse the array from start to end.
3. At each index, add the current element to `sum`.
4. Store `sum` in the result array at the same index.
5. Continue until the end of the array.

---------------------------------
Complexity:
- Time Complexity: O(n) → traverse the array once.
- Space Complexity: O(n) → for the output array.
*/
