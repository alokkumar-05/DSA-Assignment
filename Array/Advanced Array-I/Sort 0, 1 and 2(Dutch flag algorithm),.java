
/*
Problem Name: Sort Colors (Dutch National Flag Problem)
Problem Number: LeetCode 75
Problem Link: https://leetcode.com/problems/sort-colors/
*/

 class Solution {
    // Function to sort 0s, 1s, and 2s in one pass
    public void sortColors(int[] nums) {
        int low = 0;             // pointer for 0
        int mid = 0;             // pointer for 1
        int high = nums.length - 1; // pointer for 2

        // Traverse the array once
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++; // 1 is in correct place
            } else {
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

/*
---------------------------------
Logic:
1. Use three pointers → low, mid, high.
2. Swap elements to partition 0s, 1s, and 2s in one pass.
3. Ensure in-place sorting without extra space.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
