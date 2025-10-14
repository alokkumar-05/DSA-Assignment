import java.util.HashMap;

/*
Problem Name: Max Frequency Elements
Problem Link: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
*/

class Solution {
    // Function to calculate sum of elements with maximum frequency
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Find the maximum frequency
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        // Count how many elements have the maximum frequency
        int count = 0;
        for (int value : map.values()) {
            if (value == max) {
                count++;
            }
        }

        // Return total sum: max frequency * number of elements with that frequency
        return max * count;
    }
}

/*
---------------------------------
Logic:
1. Use a HashMap to count the frequency of each element in the array.
2. Find the maximum frequency among all elements.
3. Count how many elements have this maximum frequency.
4. Return the product of maximum frequency and the count of elements with that frequency.

---------------------------------
Complexity:
- Time Complexity: O(n) → one pass to count frequencies, one pass to find max, one pass to count.
- Space Complexity: O(n) → HashMap stores frequencies of all elements.
*/
