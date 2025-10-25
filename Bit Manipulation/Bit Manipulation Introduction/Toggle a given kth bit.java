
/*
Problem Name: Toggle Bits Given Range
Platform: GeeksforGeeks
Link: https://practice.geeksforgeeks.org/problems/toggle-bits-given-range2553/
*/

 class ToggleBitsInRange {

    static int toggleBits(int n, int l, int r) {
        // Create a mask for bits from l to r
        int mask = ((1 << (r - l + 1)) - 1) << (l - 1);

        // Toggle bits using XOR operation
        return n ^ mask;
    }
}

/*
---------------------------------
Logic:
1. Create bitmask with bits from l to r set to 1.
2. XOR (^) n with mask to flip those bits.
---------------------------------
Complexity:
- Time: O(1)
- Space: O(1)
*/
