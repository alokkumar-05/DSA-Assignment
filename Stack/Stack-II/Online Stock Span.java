import java.util.Stack;

/*
Problem Name: Online Stock Span
Problem Number: LeetCode 901
Problem Link: https://leetcode.com/problems/online-stock-span/
*/

 class StockSpanner {
    
    private Stack<int[]> stack; // Stack stores [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }

    // Returns the stock span for today's price
    public int next(int price) {
        int span = 1; // At least today counts

        // Merge with previous days having smaller/equal prices
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add their spans to current span
        }

        // Push current day's price and its total span
        stack.push(new int[]{price, span});

        return span;
    }
}

/*
---------------------------------
Logic:
1. Maintain a stack of (price, span).
2. For each new price:
   - Start span = 1.
   - Pop all prices <= current and add their spans.
   - Push (price, span).
3. Return the span.

---------------------------------
Complexity:
- Time Complexity: O(1) amortized
- Space Complexity: O(n)
*/
