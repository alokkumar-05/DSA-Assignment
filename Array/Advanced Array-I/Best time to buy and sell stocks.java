
/*
Problem Name: Best Time to Buy and Sell Stock
Problem Number: LeetCode 121
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
 class Solution {
    // Function to calculate maximum profit from stock prices
    public int maxProfit(int[] prices) {
        int pro = 0;             // maximum profit
        int buy = prices[0];     // lowest price so far

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                // Calculate profit and update maximum if greater
                pro = Math.max(pro, prices[i] - buy);
            } else {
                // Update buying price when a lower price is found
                buy = prices[i];
            }
        }

        return pro; // Return the maximum profit
    }
}

/*
---------------------------------
Logic:
1. Track the lowest price so far (`buy`).
2. For each day:
   - If current price > buy → compute profit.
   - Update max profit.
   - Else, update buy to current lower price.
3. Return max profit at the end.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
