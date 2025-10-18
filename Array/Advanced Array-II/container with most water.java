
/*
Problem Name: Container With Most Water
Problem Number: LeetCode 11
Problem Link: https://leetcode.com/problems/container-with-most-water/
*/

class Solution {
    // Function to calculate the maximum area of water container
    public int maxArea(int[] height) {
        int left = 0;                      // left pointer
        int right = height.length - 1;     // right pointer
        int maxAr = 0;                     // to store max area found

        // Move both pointers towards center
        while (left < right) {
            int h = Math.min(height[left], height[right]); // effective height
            int width = right - left;                      // distance between lines
            int area = h * width;                          // compute area
            maxAr = Math.max(maxAr, area);                 // update maximum

            // Move the pointer with smaller height to possibly get a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAr;
    }
}

/*
---------------------------------
Logic:
1. Use two pointers (left, right) to calculate container area.
2. Update maximum area at each step.
3. Move the pointer with smaller height inward.
4. Repeat until left < right.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
