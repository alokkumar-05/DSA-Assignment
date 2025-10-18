package Array;

/*
Problem Name: Majority Element
Problem Number: LeetCode 169
Problem Link: https://leetcode.com/problems/majority-element/
*/

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        // Create a hashmap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityElement = 0;
        int maxCount = 0;

        // Find the element with the highest frequency
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > maxCount) {
                maxCount = count;
                majorityElement = key;
            }
        }

        return majorityElement;
    }
}

/*
---------------------------------
Logic:
1. Store frequency of all elements using a HashMap.
2. Identify the element with the maximum count.
3. Return the element that occurs more than ⌊n/2⌋ times.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
