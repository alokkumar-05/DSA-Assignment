
/*
Problem Name: Smallest Repunit Divisible by K
Platform: LeetCode
Link: https://leetcode.com/problems/smallest-integer-divisible-by-k/
*/

 class SmallestRepunitDivByK {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1; // no solution

        int remainder = 1 % k;
        int length = 1;

        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % k; // build repunit modulo k
            length++;
            if (length > k) return -1; // prevent infinite loop
        }

        return length;
    }
}

/*
---------------------------------
Logic:
1. Use modulo to simulate repunit number.
2. If remainder becomes 0, return length.
3. Return -1 if no solution.
---------------------------------
Complexity:
- Time: O(k)
- Space: O(1)
*/
