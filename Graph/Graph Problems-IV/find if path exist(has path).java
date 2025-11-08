
import java.util.*;

/*
Problem Name: Find if Path Exists in Graph
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/find-if-path-exists-in-graph/
*/

 class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: BFS traversal
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        // Step 3: Standard BFS until destination found
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) return true;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false; // destination not reachable
    }
}

/*
----------------------------------------
Logic Summary:
1. Build adjacency list for undirected graph.
2. Use BFS to explore all reachable nodes from 'source'.
3. If 'destination' is reached → return true.
4. Otherwise → false.
----------------------------------------
Complexity:
Time: O(V + E)
Space: O(V + E)
----------------------------------------
*/

