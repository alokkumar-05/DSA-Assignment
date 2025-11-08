
import java.util.*;

/*
Problem Name: Number of Provinces
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/number-of-provinces/
*/

 class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //  Build adjacency list
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        //  Convert adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // DFS to count connected components
        int[] vis = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, adjList, vis);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis) {
        vis[node] = 1;
        for (int neighbor : adjList.get(node)) {
            if (vis[neighbor] == 0) dfs(neighbor, adjList, vis);
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Convert adjacency matrix → adjacency list.
2. Run DFS for each unvisited city to mark all connected ones.
3. Each DFS call = 1 province.
----------------------------------------
Complexity:
Time: O(N²)
Space: O(N)
----------------------------------------
*/
