
import java.util.*;

/*
Problem Name: All Paths From Source to Target
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/all-paths-from-source-to-target/
*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // start from source node
        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path)); // reached destination
            return;
        }

        for (int next : graph[node]) {
            path.add(next);           // choose
            dfs(graph, next, path, res); // explore
            path.remove(path.size() - 1); // backtrack
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Perform DFS from source node (0).
2. Track path and add to result when reaching destination (n - 1).
3. Use backtracking to explore all possible paths in DAG.
----------------------------------------
Complexity:
Time: O(2^N)
Space: O(N)
----------------------------------------
*/
