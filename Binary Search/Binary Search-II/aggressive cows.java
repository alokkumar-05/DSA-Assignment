import java.util.Arrays;

/*
Problem Name: Aggressive Cows
Problem Link: https://practice.geeksforgeeks.org/problems/aggressive-cows/0
*/

 class AggressiveCows {

    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // place first cow at first stall
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count == k) return true; // all cows placed
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // sort stall positions

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

}

/*
---------------------------------
Logic:
1. Sort stall positions.
2. Binary search on possible distances.
3. Greedily check if distance is feasible.
4. Return the maximum distance.
---------------------------------
Complexity:
- Time: O(n log n + n log(maxDist))
- Space: O(1)
---------------------------------
*/
