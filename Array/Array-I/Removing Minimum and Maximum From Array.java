package Array;

/*
Problem Name: Minimum Deletions to Remove Min and Max
Problem Link: (Add link if available)
*/

class Solution {
    // Function to find minimum deletions to remove both min and max
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = nums[0], max = nums[0];
        int minInd = 0, maxInd = 0;

        // Find minimum and maximum values and their indices
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minInd = i;
            }
        }

        // Option 1: Remove min from start and max from end
        int dist1 = (minInd + 1) + (n - maxInd);
        // Option 2: Remove max from start and min from end
        int dist2 = (maxInd + 1) + (n - minInd);
        // Option 3: Remove both from the start only
        int dist3 = Math.max(minInd + 1, maxInd + 1);
        // Option 4: Remove both from the end only
        int dist4 = Math.max(n - minInd, n - maxInd);

        // Return the minimum deletions among all 4 options
        return Math.min(Math.min(dist1, dist2), Math.min(dist3, dist4));
    }
}

/*
---------------------------------
Logic:
1. Find the minimum and maximum elements and their indices in the array.
2. Consider 4 possible deletion strategies:
   a) Remove min from start, max from end.
   b) Remove max from start, min from end.
   c) Remove both from start only.
   d) Remove both from end only.
3. Compute the number of deletions required for each strategy.
4. Return the minimum number among all 4 strategies.

---------------------------------
Complexity:
- Time Complexity: O(n) → one traversal to find min and max, constant time for calculations.
- Space Complexity: O(1) → only variables used, no extra data structures.
*/
