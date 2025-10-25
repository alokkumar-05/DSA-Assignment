import java.util.*;

/*
Problem Name: Top K Frequent Elements
Platform: LeetCode 
Link: https://leetcode.com/problems/top-k-frequent-elements/
*/

 class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}

/*
---------------------------------
Logic:
1. Count frequency of each element using a HashMap.
2. Use Max Heap to sort by frequency.
3. Extract top k elements.
---------------------------------
Complexity:
- Time: O(N log N)
- Space: O(N)
*/
