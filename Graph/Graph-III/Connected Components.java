
import java.util.*;

/*
Problem Name: Number of Connected Components in an Undirected Graph
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
*/

 class Solution {
    public int countComponents(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // Step 2: DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                components++;
            }
        }

        return components;
    }

    // Recursive DFS
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Build adjacency list for all edges.
2. For each unvisited node, run DFS and count components.
3. Each DFS traversal marks a complete connected component.
----------------------------------------
Complexity:
Time: O(V + E)
Space: O(V + E)
----------------------------------------
*/

