
package Recursion;

class Solution {
    // Function to find the nth Fibonacci number recursively
    public static int nthFibonacci(int n) {
        if (n == 0 || n == 1) return n; // Base cases
        return nthFibonacci(n - 1) + nthFibonacci(n - 2); // Recursive call
    }

}

/*
---------------------------------
Logic:
1. Base case: F(0) = 0, F(1) = 1
2. Recursive case: F(n) = F(n-1) + F(n-2)
---------------------------------
Complexity:
- Time Complexity: O(2^n)
- Space Complexity: O(n) (recursion stack)
*/
