
import java.util.HashMap;

/*
Problem Name: Largest Subarray with Sum 0
Problem Link: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum-1587115621/
*/

 class LargestSubarraySumZero {

    public static int maxLength(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1; // subarray from 0 to i
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum)); // update max length
            } else {
                map.put(sum, i); // store first occurrence of sum
            }
        }

        return maxLen;
    }
}

/*
---------------------------------
Logic:
1. Maintain running sum while traversing the array.
2. If sum = 0, update maxLen = current index + 1.
3. If sum seen before, update maxLen = i - firstIndex.
4. Else, store sum with its first occurrence.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
