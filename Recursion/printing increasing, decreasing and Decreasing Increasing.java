package Recursion;


 class Solution {
    // Function to print numbers from 1 to N
    public static void printTillN(int N) {
        printHelper(1, N); // Start recursion from 1
    }

    // Recursive helper function
    private static void printHelper(int current, int N) {
        if (current > N) return; // Base case
        System.out.print(current + " ");
        printHelper(current + 1, N); // Recursive call
    }

    // Main method to test the function
    public static void main(String[] args) {
        int N = 10;
        printTillN(N);
    }
}

/*
---------------------------------
Logic:
1. Use a helper function with current number.
2. Base case: current > N.
3. Print current and call helper with current + 1.
---------------------------------
Complexity:
- Time Complexity: O(N)
- Space Complexity: O(N) (recursion stack)
*/
