package Array;

/*
Problem Name: Maximum Subarray
Problem Link: https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int maxSum = nums[0];   
        int currSum = nums[0];  
        
        for (int i = 1; i < n; i++) {
            // Update current sum either start a new subarray or continue existing one
            currSum = Math.max(nums[i], currSum + nums[i]);
            // Update maxSum if current sum is greater
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum; // Return the overall maximum subarray sum
    }
}

/*
---------------------------------
Logic:
1. Initialize currSum and maxSum as the first element.
2. Traverse the array:
   - currSum = max(current element, currSum + current element)
   - maxSum = max(maxSum, currSum)
3. Return maxSum.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
