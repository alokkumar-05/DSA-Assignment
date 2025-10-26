
import java.util.Arrays;

/*
Problem Name: Max Chunks To Make Sorted II
Platform: LeetCode
Link: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
*/

 class MaxChunksToSortedII {

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); // Sorted version of the array

        int chunks = 0;
        long sumOriginal = 0; // Prefix sum of original array
        long sumSorted = 0;   // Prefix sum of sorted array

        for (int i = 0; i < n; i++) {
            sumOriginal += arr[i];
            sumSorted += sortedArr[i];

            // If prefix sums match, current chunk is complete
            if (sumOriginal == sumSorted) {
                chunks++;
            }
        }

        return chunks;
    }
}

/*
---------------------------------
Logic:
1. Sort array to compare with original.
2. Keep prefix sums of both arrays.
3. When sums are equal, a chunk can be formed.
4. Count total chunks.
---------------------------------
Complexity:
- Time: O(n log n)
- Space: O(n)
*/
