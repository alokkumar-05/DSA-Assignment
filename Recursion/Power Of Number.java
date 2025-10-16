package Recursion;


 class Solution {
    // Function to compute n^(reverse of n)
    public static int reverseExponentiation(int n) {
        int rev = 0;
        int temp = n;

        // Reverse the number
        while (temp != 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }

        // Compute n^rev iteratively
        long result = 1;
        for (int i = 0; i < rev; i++) {
            result *= n;

            // Check for overflow
            if (result > Integer.MAX_VALUE) {
                return -1;
            }
        }

        return (int) result;
    }

    
}

/*
---------------------------------
Logic:
1. Reverse the number n.
2. Compute n^rev iteratively.
3. Check for overflow and return -1 if exceeded.
---------------------------------
Complexity:
- Time Complexity: O(log n + rev)
- Space Complexity: O(1)
*/
