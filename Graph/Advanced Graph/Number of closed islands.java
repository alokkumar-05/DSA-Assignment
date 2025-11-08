
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
        boolean[][] visited = new boolean[n][m];
        int islands = 0;

        // Traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        visited[row][col] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(newRow, newCol, grid, visited);
            }
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Traverse grid and start DFS from each unvisited land cell ('1').
2. Mark all connected land cells visited.
3. Each DFS = 1 island.
----------------------------------------
Complexity:
Time: O(N × M)
Space: O(N × M)
----------------------------------------
*/
