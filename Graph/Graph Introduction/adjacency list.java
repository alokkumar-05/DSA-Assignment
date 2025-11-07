
import java.util.*;

/*
Problem Name: Print Adjacency List
Platform: GeeksforGeeks
Difficulty: Easy
Link: https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
*/

class Solution {
    // Function to return adjacency list representation of a graph
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Step 1: Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add both directions since graph is undirected
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 3: Return final adjacency list
        return adj;
    }
}

/*
------------------------------------------
Logic Summary:
1. Initialize an ArrayList for each vertex.
2. For each edge (u, v):
   - Add v to u’s adjacency list
   - Add u to v’s adjacency list
3. Return the adjacency list.
------------------------------------------
Complexity:
Time: O(V + E)
Space: O(V + E)
------------------------------------------
*/

