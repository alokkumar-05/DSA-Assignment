
import java.util.HashMap;

/*
Problem Name: Two Sum
Problem Number: LeetCode 1
Problem Link: https://leetcode.com/problems/two-sum/
*/

 class Solution {
    // Function to return indices of two numbers that sum up to target
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores number → index
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i]; // complement to reach target

            // If complement exists, return indices
            if (map.containsKey(req)) {
                ans[0] = i;
                ans[1] = map.get(req);
                break;
            } else {
                // Store current number and its index
                map.put(nums[i], i);
            }
        }

        return ans;
    }
}

/*
---------------------------------
Logic:
1. Use a HashMap to store previously seen numbers and their indices.
2. For each element, check if its complement (target - nums[i]) exists in map.
3. If yes → return both indices.
4. If no → store current element in map and continue.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
