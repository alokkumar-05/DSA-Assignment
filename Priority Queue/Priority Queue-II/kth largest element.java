
import java.util.PriorityQueue;

/*
Problem Name: Kth Largest Element in an Array
LeetCode: 215
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

 class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 1: Insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Step 2: For rest of the elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();       // remove smallest
                pq.add(nums[i]); // add new element
            }
        }

        // Step 3: kth largest element at root
        return pq.peek();
    }
}

/*
---------------------------------
Logic:
1. Maintain a min-heap of size k.
2. Replace root if a bigger number is found.
3. Final root = kth largest element.
---------------------------------
Complexity:
- Time: O(n log k)
- Space: O(k)
*/
