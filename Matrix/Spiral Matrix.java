package Recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to return matrix elements in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;

        while (left <= right && top <= bottom) {
            // Traverse left → right
            for (int i = left; i <= right; i++) ans.add(matrix[top][i]);
            top++;

            // Traverse top → bottom
            for (int i = top; i <= bottom; i++) ans.add(matrix[i][right]);
            right--;

            // Traverse right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) ans.add(matrix[bottom][i]);
                bottom--;
            }

            // Traverse bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
    }

}

/*
---------------------------------
Logic:
1. Maintain top, bottom, left, right boundaries.
2. Traverse outer layer in spiral order: left→right, top→bottom, right→left, bottom→top.
3. Shrink boundaries and repeat until all elements are traversed.
---------------------------------
Complexity:
- Time Complexity: O(n*m)
- Space Complexity: O(n*m)
*/
