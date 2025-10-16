package Recursion;

 class Solution {
    // Function to search target in a sorted 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1; // Start top-right

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true; // Found target
            if (matrix[i][j] < target) i++; // Move down
            else j--; // Move left
        }

        return false; // Target not found
    }

}

/*
---------------------------------
Logic:
1. Start from top-right corner.
2. If element == target → return true.
3. If element < target → move down.
4. If element > target → move left.
5. Repeat until boundaries exceeded.
---------------------------------
Complexity:
- Time Complexity: O(n + m)
- Space Complexity: O(1)
*/

