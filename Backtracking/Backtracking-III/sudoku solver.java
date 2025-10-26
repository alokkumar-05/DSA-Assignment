
/*
Problem Name: Sudoku Solver
Platform: LeetCode
Link: https://leetcode.com/problems/sudoku-solver/
*/

class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (row == 8 && col == 9) return true;
        if (col == 9) { row++; col = 0; }

        if (board[row][col] != '.') return backtrack(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (backtrack(board, row, col + 1)) return true;
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == ch || board[i][col] == ch) return false;

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] == ch) return false;

        return true;
    }
}

/*
---------------------------------
Logic:
1. Backtrack to fill empty cells.
2. Check row, column, and 3x3 subgrid before placing a digit.
3. Backtrack if placement leads to no solution.
---------------------------------
Complexity:
- Time: O(9^(n*n))
- Space: O(n^2) recursion stack
*/
