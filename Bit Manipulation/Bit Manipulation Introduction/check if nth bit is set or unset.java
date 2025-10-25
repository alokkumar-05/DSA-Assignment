
/*
Problem Name: Check if Kth Bit is Set
Platform: GeeksforGeeks
Link: https://practice.geeksforgeeks.org/problems/check-whether-kth-bit-is-set-or-not-1587115620/
*/
 class CheckKthBit {

    static boolean checkKthBit(int n, int k) {
        // Create a mask with only the kth bit set
        int mask = 1 << k;

        // Check if kth bit in n is set
        return (n & mask) != 0;
    }
}

/*
---------------------------------
Logic:
1. Create mask with kth bit set using 1 << k.
2. AND n with mask to check if kth bit is set.
---------------------------------
Complexity:
- Time: O(1)
- Space: O(1)
*/
