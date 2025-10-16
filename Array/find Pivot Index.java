package Array;

/*
Problem Name: Find Pivot Index
Problem Link: https://leetcode.com/problems/find-pivot-index/
*/

class Solution {
    // Function to find the pivot index where left sum == right sum
    public int pivotIndex(int[] nums) {
        int totalSum = 0;   // Total sum of all elements
        int leftSum = 0;    // Running sum of left elements

        // Step 1: Calculate total sum of array
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Traverse array to find pivot index
        for (int i = 0; i < nums.length; i++) {
            // If left and right sums are equal → found pivot
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i]; // Update left sum
        }

        return -1; // If no pivot found
    }
}

/*
---------------------------------
Logic:
1. Compute total sum of all elements.
2. Iterate while maintaining left sum.
3. At each index, if left sum == (total sum - left sum - current element),
   that index is the pivot.
4. Otherwise, return -1 if none found.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
