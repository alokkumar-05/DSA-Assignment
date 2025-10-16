package Matrix;

class Solution {
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    private static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; // swap
            }
        }
    }

    private static void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[i].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp; // reverse row
                left++;
                right--;
            }
        }
    }

  
    
}

/*
---------------------------------
Logic:
1️ Transpose the matrix by swapping matrix[i][j] with matrix[j][i].
2️ Reverse each row to complete the 90° rotation.
---------------------------------
Complexity:
- Time: O(n²)
- Space: O(1)
---------------------------------
*/
