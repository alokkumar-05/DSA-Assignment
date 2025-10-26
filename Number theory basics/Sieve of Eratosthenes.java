import java.util.*;

/*
Problem Name: Count Primes
Platform: LeetCode
Link: https://leetcode.com/problems/count-primes/
*/

 class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) isPrime[j] = false; // mark multiples non-prime
            }
        }

        int count = 0;
        for (boolean prime : isPrime) if (prime) count++; // count primes

        return count;
    }
}

/*
---------------------------------
Logic:
1. Sieve of Eratosthenes to mark non-primes.
2. Count remaining true values as primes.
---------------------------------
Complexity:
- Time: O(n log log n)
- Space: O(n)
*/
