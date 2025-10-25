
import java.util.Collections;
import java.util.PriorityQueue;

/*
Problem Name: Kth Smallest Element in an Array
Platform: GFG / LeetCode
Link: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/
*/

 class KthSmallestElement {

    public static int kthSmallest(int[] arr, int k) {
        // Max heap to store k smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // remove largest
            }
        }

        return pq.peek(); // kth smallest
    }
}

/*
---------------------------------
Logic:
1. Use Max Heap to keep k smallest elements.
2. If heap size > k, remove largest element.
3. The root (peek) is kth smallest.
---------------------------------
Complexity:
- Time: O(n log k)
- Space: O(k)
*/
