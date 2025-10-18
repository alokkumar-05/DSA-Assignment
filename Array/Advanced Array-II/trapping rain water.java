
/*
Problem Name: Trapping Rain Water
Problem Number: LeetCode 42
Problem Link: https://leetcode.com/problems/trapping-rain-water/
*/

class Solution {
    // Function to calculate trapped rainwater
    public int trap(int[] height) {
        int left = 0;                       // left pointer
        int right = height.length - 1;      // right pointer
        int total = 0;                      // total trapped water
        int leftMax = height[left];         // highest left boundary
        int rightMax = height[right];       // highest right boundary

        // Process until pointers meet
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left]; // add trapped water
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right]; // add trapped water
                right--;
            }
        }

        return total;
    }
}

/*
---------------------------------
Logic:
1. Use two pointers (left and right).
2. Maintain leftMax and rightMax.
3. Move the smaller side inward to calculate trapped water.
4. Add water trapped based on the current min boundary.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
