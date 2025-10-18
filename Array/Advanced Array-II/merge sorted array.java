

/*
Problem Name: Merge Sorted Array
Problem Number: LeetCode 88
Problem Link: https://leetcode.com/problems/merge-sorted-array/
*/

 class Solution {
    // Function to merge two sorted arrays
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[m + n]; // temporary array to store merged elements

        // Merge process
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        // Copy any remaining elements
        while (i < m) arr[k++] = nums1[i++];
        while (j < n) arr[k++] = nums2[j++];

        // Copy merged array back to nums1
        for (int x = 0; x < m + n; x++) {
            nums1[x] = arr[x];
        }
    }
}

/*
---------------------------------
Logic:
1. Use two-pointer technique (i for nums1, j for nums2).
2. Compare and insert smaller elements into new array.
3. Copy back merged result into nums1.

---------------------------------
Complexity:
- Time Complexity: O(m + n)
- Space Complexity: O(m + n)
*/
