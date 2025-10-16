
package Recursion;

 class Solution {
    // Function to calculate sum of array elements
    public static int arraySum(int arr[]) {
        return arraySumHelper(arr, arr.length);
    }

    // Recursive helper function
    private static int arraySumHelper(int[] arr, int n) {
        if (n == 0) return 0; // Base case
        return arr[n - 1] + arraySumHelper(arr, n - 1); // Recursive sum
    }
}

/*
---------------------------------
Logic:
1. Base case: if n == 0, return 0.
2. Recursive case: sum last element + sum of first n-1 elements.
---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
