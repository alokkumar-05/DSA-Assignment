
/*
Problem Name: Number of Islands
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/number-of-islands/
*/

 class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int island = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, vis);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        int n = grid.length, m = grid[0].length;
        vis[row][col] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                grid[newRow][newCol] == '1' && !vis[newRow][newCol]) {
                dfs(newRow, newCol, grid, vis);
            }
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Traverse the grid.
2. For each unvisited land cell, perform DFS to mark connected land.
3. Count every DFS initiation as a new island.
----------------------------------------
Complexity:
Time: O(N × M)
Space: O(N × M)
----------------------------------------
*/
