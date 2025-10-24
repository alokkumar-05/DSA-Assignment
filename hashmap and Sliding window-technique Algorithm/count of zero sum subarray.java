
import java.util.HashMap;

/*
Problem Name: Count Subarrays with Sum 0
Problem Link: https://practice.geeksforgeeks.org/problems/count-subarrays-with-sum-0-1587115621
*/

 class CountSubarraysSumZero {

    public static int findSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                count++; // subarray from 0 to i
            }

            if (map.containsKey(sum)) {
                count += map.get(sum); // previous occurrences
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

/*
---------------------------------
Logic:
1. Maintain running sum while traversing the array.
2. If sum = 0, increment count.
3. If sum seen before, add its frequency to count.
4. Update map with current sum frequency.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
