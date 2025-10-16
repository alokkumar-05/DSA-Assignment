package Recursion;

 class Solution {
    // Function to count digits of n that divide n
    public static int evenlyDivides(int n) {
        int count = 0;
        int temp = n;

        // Traverse each digit
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0 && n % digit == 0) { // Check divisibility
                count++;
            }
            temp /= 10; // Remove last digit
        }

        return count;
    }

   

}

/*
---------------------------------
Logic:
1. Traverse each digit of n.
2. If digit != 0 and divides n exactly, increment count.
3. Return count.
---------------------------------
Complexity:
- Time Complexity: O(log n)
- Space Complexity: O(1)
*/
