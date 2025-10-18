
/*
Problem Name: Search in Rotated Sorted Array
Problem Number: LeetCode 33
Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

 class Solution {
    // Function to find the target index using modified binary search
    public int search(int[] nums, int target) {
        return src(nums, target, 0, nums.length - 1);
    }

    private int src(int[] nums, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            // Found target
            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1; // target lies in left half
                } else {
                    s = mid + 1; // target lies in right half
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1; // target lies in right half
                } else {
                    e = mid - 1; // target lies in left half
                }
            }
        }

        return -1; // target not found
    }
}

/*
---------------------------------
Logic:
1. Use binary search to handle rotated sorted array.
2. Identify sorted half at each step.
3. Narrow down to the half that may contain target.

---------------------------------
Complexity:
- Time Complexity: O(log n)
- Space Complexity: O(1)
*/
