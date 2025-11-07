

import java.util.*;

/*
Problem Name: Detect Cycle in Directed Graph
Platform: GeeksforGeeks / LeetCode
Difficulty: Medium
Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/
 class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Step 2: DFS for each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, adj, visited, recStack)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle
    }

    // Step 3: Recursive DFS with recursion stack
    private boolean dfsCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && dfsCycle(neighbor, adj, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true; // back edge found
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }
}

/*
----------------------------------------
Logic Summary:
1. Build adjacency list for directed graph.
2. Use DFS with a recursion stack to track path.
3. If a node is visited again while still in stack → cycle detected.
----------------------------------------
Complexity:
Time: O(V + E)
Space: O(V)
----------------------------------------
*/

