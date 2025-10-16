package Array;

/*
Problem Name: Maximum Product Subarray
Problem Link: https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    // Function to find the maximum product subarray
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0]; 
        int minSoFar = nums[0]; 
        int ans = nums[0];      

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If the number is negative, swap maxSoFar and minSoFar
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Calculate max and min product ending at current index
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update answer
            ans = Math.max(ans, maxSoFar);
        }

        return ans; // Return the overall maximum product subarray
    }
}

/*
---------------------------------
Logic:
1. Keep track of both max and min products at each index.
2. Swap them when encountering a negative number (sign flip).
3. Update maxSoFar and minSoFar accordingly.
4. The final result is the maximum value stored in ans.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

