package Array;

/*
Problem Name: Rotate Array
Problem Link: (Add link if available)
*/

class Solution {
    // Function to rotate the array to the right by k steps
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Handle case when k is greater than array size
        k = k % n;

        // Temporary array to store rotated result
        int[] temp = new int[n];

        // Place each element at its correct rotated index
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // Copy the rotated elements back to the original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}

/*
---------------------------------
Logic:
1. Create a temporary array of the same size.
2. For each element at index i, move it to index (i + k) % n.
3. Copy the result from the temporary array back to nums.

---------------------------------
Complexity:
- Time Complexity: O(n) → two passes over the array.
- Space Complexity: O(n) → using an extra temporary array.
*/
