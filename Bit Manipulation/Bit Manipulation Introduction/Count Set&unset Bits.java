
/*
Problem Name: Count Total Set Bits
Platform: GeeksforGeeks
Link: https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/
*/

 class CountTotalSetBits {

    public static int countSetBits(int n) {
        if (n == 0)
            return 0;

        // Find the largest power of 2 less than or equal to n
        int x = largestPowerOf2(n);

        // Total set bits till 2^x - 1
        int bitsTill2x = x * (1 << (x - 1));

        // MSB contribution from numbers 2^x to n
        int msbBits = n - (1 << x) + 1;

        // Recursive call for remaining numbers
        int rest = countSetBits(n - (1 << x));

        return bitsTill2x + msbBits + rest;
    }

    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;
    }
}

/*
---------------------------------
Logic:
1. Find highest power of 2 ≤ n.
2. Count bits till 2^x - 1 using formula.
3. Add MSB contribution for numbers from 2^x to n.
4. Recursively count remaining bits for (n - 2^x).
---------------------------------
Complexity:
- Time: O(log n)
- Space: O(log n)
*/
