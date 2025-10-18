
/*
Problem Name: Search in Rotated Sorted Array II
Problem Number: 81
Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*/

 class Solution {
    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return true;

            // Handle duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Left part sorted
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            // Right part sorted
            else {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;

        System.out.println("Target found? " + search(nums, target));
    }
}

/*
---------------------------------
Logic:
1. Modified binary search on rotated array.
2. Handle duplicates by shrinking boundaries.
3. Identify sorted half and check if target lies there.
---------------------------------
Complexity:
- Time: O(log n) average, O(n) worst-case with duplicates
- Space: O(1)
---------------------------------
*/
