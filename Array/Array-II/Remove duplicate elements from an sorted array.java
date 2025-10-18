package Array;

/*
Problem Name: Remove Duplicates from Sorted Array
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/

class Solution {
    // Function to remove duplicates from a sorted array
    public int removeDuplicates(int[] nums) {
        // Edge case: if array is empty
        if (nums.length == 0) {
            return 0;
        }

        int j = 1; // index to place the next unique element

        // Start from the 2nd element and compare with the previous one
        for (int i = 1; i < nums.length; i++) {
            // When a new unique element is found
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i]; // overwrite duplicate
                j++;               // move to next unique position
            }
        }

        // Return total number of unique elements
        return j;
    }
}

/*
---------------------------------
Logic:
1. Since the array is sorted, duplicates are adjacent.
2. Maintain a pointer j that tracks the position of the next unique element.
3. Iterate from index 1 to n - 1:
   - If nums[i] != nums[i - 1], copy nums[i] to nums[j] and increment j.
4. Return j as the count of unique elements.

---------------------------------
Complexity:
- Time Complexity: O(n) → single traversal of the array.
- Space Complexity: O(1) → in-place operation without extra storage.
*/
