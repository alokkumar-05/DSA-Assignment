
/*
Problem Name: Flood Fill
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/flood-fill/
*/
 class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (initialColor == color) return image;

        int n = image.length, m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(image, sr, sc, initialColor, color, visited);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int initialColor, int newColor, boolean[][] visited) {
        int n = image.length, m = image[0].length;
        visited[row][col] = true;
        image[row][col] = newColor;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                !visited[newRow][newCol] && image[newRow][newCol] == initialColor) {
                dfs(image, newRow, newCol, initialColor, newColor, visited);
            }
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Store initial color at (sr, sc).
2. If same as new color, no operation needed.
3. Perform DFS to recolor connected cells having same initial color.
4. Explore 4 directions (up, down, left, right).
----------------------------------------
Complexity:
Time: O(N × M)
Space: O(N × M)
----------------------------------------
*/
