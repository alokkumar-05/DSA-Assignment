 class Solution {

    /*-----------------------------------------------------------
     * 1. DP Relation using (i >> 1) + (i & 1) – BEST APPROACH
     *-----------------------------------------------------------*/
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    /*-----------------------------------------------------------
     * 2. DP Based on largest power of 2 ≤ i
     *-----------------------------------------------------------*/
    public int[] countBitsPower(int n) {
        int[] ans = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            ans[i] = 1 + ans[i - offset];
        }

        return ans;
    }  
}

/*
---------------------------------------------------------
Logic Summary:
1. ans[i] = ans[i >> 1] + (i & 1)
2. Uses previous results → DP
3. Computes number of set bits in O(1) for each i
---------------------------------------------------------
Complexity:
Time: O(n)
Space: O(n)
---------------------------------------------------------
*/
