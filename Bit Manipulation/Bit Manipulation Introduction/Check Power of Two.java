/*
Problem Name: Check Power of Two
Platform: LeetCode / GeeksforGeeks
Link: https://leetcode.com/problems/power-of-two/
*/
 class CheckPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        // A number is power of two if only one bit is set
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}

/*
---------------------------------
Logic:
1. Power of two numbers have only one set bit.
2. Use n & (n-1) trick to check.
3. Ensure n > 0 to exclude zero or negatives.
---------------------------------
Complexity:
- Time: O(1)
- Space: O(1)
*/
