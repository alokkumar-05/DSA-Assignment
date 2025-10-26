
import java.util.Arrays;

/*
Problem Name: Minimum Number of Platforms
Platform: GFG / LeetCode
Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
*/

 class MinimumPlatforms {

    public static int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;

        // Sort arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat = 1;      // Platforms needed for first train
        int result = 1;    // Maximum platforms needed
        int i = 1, j = 0;  // i -> next arrival, j -> next departure

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) { // Train arrives before earliest departure
                plat++;             // Allocate a new platform
                i++;
            } else {                // Train departs, free a platform
                plat--;
                j++;
            }
            result = Math.max(result, plat); // Update max platforms needed
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Sort arrival and departure times.
2. Use two pointers to simulate trains arriving and leaving.
3. Increment platforms when a train arrives before earliest departure.
4. Decrement platforms when a train departs.
5. Track the maximum platforms needed at any time.
---------------------------------
Complexity:
- Time: O(n log n) (sorting)
- Space: O(1)
*/
