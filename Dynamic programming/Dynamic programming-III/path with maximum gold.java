class PathWithMaxGold {

    private int maxGold = 0;
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int[][] grid, int r, int c, int currSum) {
        int gold = grid[r][c];
        currSum += gold;
        maxGold = Math.max(maxGold, currSum);

        grid[r][c] = 0;  // mark visited

        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];

            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                    && grid[nr][nc] > 0) {
                dfs(grid, nr, nc, currSum);
            }
        }

        grid[r][c] = gold; // backtrack
    }
}

/*
---------------------------------------------------------
Logic Summary:
DFS on each gold cell.
Mark visited as 0 → explore 4 directions → backtrack.
Keep track of maximum collected path.
---------------------------------------------------------
Time: O((n*m) * 4^(n*m))
Space: O(n*m)
---------------------------------------------------------
*/
