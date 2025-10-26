
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: N-Queens
Platform: LeetCode
Link: https://leetcode.com/problems/n-queens/
*/

 class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(board, 0, result);
        return result;
    }

    private void helper(int[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(buildBoard(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1;
                helper(board, row + 1, result);
                board[row][col] = 0;
            }
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 1) return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 1) return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) if (board[i][j] == 1) return false;
        return true;
    }

    private List<String> buildBoard(int[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) sb.append(board[i][j] == 1 ? "Q" : ".");
            result.add(sb.toString());
        }
        return result;
    }
}

/*
---------------------------------
Logic:
1. Backtrack row by row placing queens.
2. Validate column & diagonals.
3. Backtrack to explore all placements.
---------------------------------
Complexity:
- Time: O(N!)
- Space: O(N^2)
*/
