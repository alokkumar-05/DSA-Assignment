
import java.util.HashMap;
import java.util.Map;

/*
Problem Name: Missing Number
Problem Link: https://leetcode.com/problems/missing-number/
*/

 class MissingNumber {

    public static int missingNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        // initialize map with 0 to n
        for (int i = 0; i <= n; i++) {
            map.put(i, 0);
        }

        // mark numbers present in array
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // find missing number
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) return entry.getKey();
        }

        return -1;
    }
}

/*
---------------------------------
Logic:
1. Track numbers 0..n in HashMap.
2. Increment count for each number in array.
3. Return number with 0 count.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
