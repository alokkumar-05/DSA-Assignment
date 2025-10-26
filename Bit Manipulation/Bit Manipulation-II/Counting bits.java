
/*
Problem Name: Counting Bits
Platform: LeetCode
Link: https://leetcode.com/problems/counting-bits/
*/

 class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // 0 has 0 set bits

        for (int i = 1; i <= n; i++) {
            // Number of set bits = set bits of i/2 + last bit
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}

/*
---------------------------------
Logic:
1. DP approach: ans[i] = ans[i >> 1] + (i & 1)
2. Right shift removes last bit, (i & 1) checks last bit
3. Iterate from 1 to n and fill ans array
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
