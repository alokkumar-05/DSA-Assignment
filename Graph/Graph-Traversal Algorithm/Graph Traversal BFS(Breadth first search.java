
import java.util.*;

/*
Problem Name: BFS Traversal of Graph
Platform: GeeksforGeeks
Difficulty: Easy
Link: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
*/
 class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // Step 1: Start BFS from node 0
        visited[0] = true;
        q.add(0);

        // Step 2: Standard BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            // Step 3: Visit all unvisited adjacent nodes
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Return BFS order
        return bfs;
    }
}

/*
----------------------------------------
Logic Summary:
1. Start from node 0 and use a queue.
2. Mark visited[] to avoid revisits.
3. Push all unvisited adjacent nodes.
4. Continue until queue is empty.
----------------------------------------
Complexity:
Time: O(V + E)
Space: O(V)
----------------------------------------
*/

