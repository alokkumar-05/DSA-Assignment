
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Problem Name: Next Greater Element I
Problem Number: LeetCode 496
Problem Link: https://leetcode.com/problems/next-greater-element-i/
*/

 class Solution {
    // Function to find next greater element of nums1 elements in nums2
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // Map from element → next greater
        Stack<Integer> stack = new Stack<>();        // Monotonic decreasing stack

        // Populate map with next greater element from nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num); // Pop smaller elements and map to current
            }
            stack.push(num);
        }

        // Replace elements in nums1 with their next greater element or -1 if none
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}

/*
---------------------------------
Logic:
1. Use stack to maintain decreasing order of nums2 elements.
2. Map popped elements to current element as their next greater.
3. Update nums1 based on map or -1.
4. Return modified nums1.

---------------------------------
Complexity:
- Time Complexity: O(n1 + n2)
- Space Complexity: O(n2)
*/

