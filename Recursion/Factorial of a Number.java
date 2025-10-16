package Recursion;

class Solution {
    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n <= 1) return 1; // Base case
        return n * factorial(n - 1); // Recursive call
    }

    // Main method to test the function
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }
}

/*
---------------------------------
Logic:
1. If n <= 1, return 1
2. Otherwise, return n * factorial(n-1)
---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n) (recursion stack)
*/
