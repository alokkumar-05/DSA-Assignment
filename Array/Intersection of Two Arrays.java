package Array;

import java.util.*;

/*
Problem Name: Intersection of Two Arrays
Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/
*/

class Solution {
    // Function to find the intersection of two arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Sort both arrays for two-pointer traversal
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> st = new HashSet<>();
        int i = 0, j = 0;

        // Use two-pointer approach to find common elements
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                st.add(nums1[i]); // Add the common element
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert set to array
        int[] result = new int[st.size()];
        int idx = 0;
        for (int num : st) {
            result[idx++] = num;
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Sort both arrays to use two-pointer traversal.
2. Compare elements from both arrays:
   - If equal → add to HashSet (to avoid duplicates).
   - If nums1[i] < nums2[j] → move i forward.
   - Else → move j forward.
3. Convert the set to an array and return.

---------------------------------
Complexity:
- Time Complexity: O(n log n + m log m)
- Space Complexity: O(min(n, m))
*/
