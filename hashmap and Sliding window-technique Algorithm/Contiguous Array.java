
import java.util.HashMap;
import java.util.Map;

/*
Problem Name: Contiguous Array
Problem Number: LeetCode 525
Problem Link: https://leetcode.com/problems/contiguous-array/
*/

 class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1); // treat 0 as -1

            if (sum == 0) {
                maxLen = i + 1; // subarray from index 0 to i
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }

        return maxLen;
    }
}

/*
---------------------------------
Logic:
1. Convert 0s to -1.
2. Maintain running sum and use HashMap to track first occurrence.
3. If sum=0 or seen before, update max length.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
