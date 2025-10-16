package Matrix;

class Solution {
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0;
        int rowIndex = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++; // count number of ones
            }

            if (count > maxOnes) {
                maxOnes = count;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxOnes};
    }

}

/*
---------------------------------
Logic:
1. Traverse every row of the matrix.
2. Count the number of ones in each row.
3. Update max count and index if higher count found.
---------------------------------
Complexity:
- Time Complexity: O(n × m)
- Space Complexity: O(1)
*/
