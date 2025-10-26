

/*
Problem Name: Super Pow
Platform: LeetCode
Link: https://leetcode.com/problems/super-pow/
*/
 class SuperPow {
    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return superPowHelper(a % MOD, b, b.length);
    }

    private int superPowHelper(int a, int[] b, int len) {
        if (len == 0) return 1; // base case

        int lastDigit = b[len - 1];
        int part1 = myPow(a, lastDigit); // a^lastDigit
        int part2 = myPow(superPowHelper(a, b, len - 1), 10); // (a^rest)^10

        return (part1 * part2) % MOD;
    }

    private int myPow(int a, int k) {
        int result = 1;
        a %= MOD;
        for (int i = 0; i < k; i++) result = (result * a) % MOD; // modular exponentiation
        return result;
    }

}

/*
---------------------------------
Logic:
1. Split exponent into digits.
2. Use recursion: a^b = a^lastDigit * (a^rest)^10 % MOD
3. Use modular multiplication to prevent overflow.
---------------------------------
Complexity:
- Time: O(n * k)
- Space: O(n)
*/
