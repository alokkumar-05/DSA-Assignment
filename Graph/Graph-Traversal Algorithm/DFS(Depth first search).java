

import java.util.*;

/*
Problem Name: DFS of Graph
Platform: GeeksforGeeks
Difficulty: Easy
Link: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
*/

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        int V = adj.size();
        boolean[] visited = new boolean[V];

        // Start DFS from vertex 0
        dfsHelper(0, adj, visited, dfs);
        return dfs;
    }

    // Recursive DFS function
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        // Visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, dfs);
            }
        }
    }
}

/*
------------------------------------------
Logic Summary:
1. Start DFS from node 0.
2. Use a visited[] array to prevent revisits.
3. Recursively visit all unvisited neighbors.
------------------------------------------
Complexity:
Time: O(V + E)
Space: O(V)
------------------------------------------
*/

