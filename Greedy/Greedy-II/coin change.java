
import java.util.Arrays;

/*
Problem Name: Coin Change
Platform: LeetCode / GFG
Link: https://leetcode.com/problems/coin-change/
*/

class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int INF = amount + 1; // Represents impossible amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF); // Initialize all amounts as impossible
        dp[0] = 0;            // 0 coins needed for amount 0

        // Fill dp array for all amounts from 1 to 'amount'
        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                if (coin <= amt) { // Coin can be used
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
                }
            }
        }

        // If dp[amount] is still INF, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/*
---------------------------------
Logic:
1. Use DP array dp[amt] = min coins for amount 'amt'.
2. Initialize dp[0] = 0, dp[others] = INF.
3. For each amount, try all coins <= amount.
4. Update dp[amt] = min(dp[amt], dp[amt - coin] + 1).
5. Return dp[amount] if possible, else -1.
---------------------------------
Complexity:
- Time: O(amount * n)
- Space: O(amount)
*/
