
/*
Problem Name: Max Chunks To Make Sorted
Platform: LeetCode
Link: https://leetcode.com/problems/max-chunks-to-make-sorted/
*/

 class MaxChunksToSorted {

    public static int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0; // Track maximum value seen so far
        int chunks = 0;   // Count of chunks that can be formed

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]); // Update maximum
            if (maxSoFar == i) {                   // If max equals index, a chunk is complete
                chunks++;
            }
        }

        return chunks;
    }
}

/*
---------------------------------
Logic:
1. Keep track of max element seen so far.
2. If maxSoFar == current index, a chunk can be formed.
3. Count total chunks.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
