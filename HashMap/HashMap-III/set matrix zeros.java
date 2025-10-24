
import java.util.HashSet;
/*
Problem Name: Set Matrix Zeroes
Problem Link: https://leetcode.com/problems/set-matrix-zeroes/
*/

 class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        // record rows and columns containing 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // update the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}

/*
---------------------------------
Logic:
1. Store indices of rows and columns with 0.
2. Traverse matrix and update elements to 0 accordingly.
---------------------------------
Complexity:
- Time: O(m × n)
- Space: O(m + n)
---------------------------------
*/
