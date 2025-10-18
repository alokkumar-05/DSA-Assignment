/*
Problem Name: Koko Eating Bananas
Problem Number: LeetCode 875
Problem Link: https://leetcode.com/problems/koko-eating-bananas/
*/
 class Solution {
    // Function to find minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;                       // minimum possible speed
        int right = getMax(piles);          // maximum possible speed
        int answer = right;

        // Binary search over possible speeds
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long requiredHours = getHours(piles, mid);

            if (requiredHours <= h) {
                answer = mid;               // feasible, try smaller speed
                right = mid - 1;
            } else {
                left = mid + 1;             // not feasible, increase speed
            }
        }

        return answer;
    }

    // Helper to get maximum pile size
    private int getMax(int[] piles) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);
        return max;
    }

    // Helper to calculate total hours for given speed
    private long getHours(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            // Equivalent to ceil(pile / k)
            hours += (pile + (long)k - 1) / k;
        }
        return hours;
    }
}

/*
---------------------------------
Logic:
1. Binary search on speed 'k' between 1 and max(piles).
2. For each speed, compute total hours to finish all piles.
3. If totalHours <= h → valid speed, search left half.
4. Else → increase speed, search right half.

---------------------------------
Complexity:
- Time Complexity: O(n log m)
- Space Complexity: O(1)
*/
