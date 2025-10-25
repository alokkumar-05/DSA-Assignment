
import java.util.*;

/*
Problem Name: Sliding Window Maximum
Platform: LeetCode
Link: https://leetcode.com/problems/sliding-window-maximum/
*/

class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); // Deque to store potential max values
        int i = 0, j = 0, ptr = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1]; // Result array

        while (j < n) {
            // Remove all elements smaller than current from the back
            while (!q.isEmpty() && q.peekLast() < nums[j]) {
                q.pollLast();
            }

            q.add(nums[j]); // Add current element

            if (j - i + 1 < k) {
                j++; // Expand window
            } else if (j - i + 1 == k) {
                res[ptr++] = q.peek(); // Front is max of current window

                // Remove the element going out of window
                if (nums[i] == q.peek()) {
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }

        return res;
    }
}

/*
---------------------------------
Logic:
1. Maintain a deque in decreasing order of elements.
2. For each window, remove elements out of range.
3. The front of deque is the maximum of the current window.
---------------------------------
Complexity:
- Time: O(N)
- Space: O(k)
*/
