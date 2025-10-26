
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Generate Parentheses
Platform: LeetCode
Link: https://leetcode.com/problems/generate-parentheses/
*/
 class GenerateParentheses {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, "", 0, 0);
        return result;
    }

    private void backtrack(int n, String curr, int open, int close) {
        if (curr.length() == 2 * n) { // valid combination
            result.add(curr);
            return;
        }

        if (open < n) { // add '('
            backtrack(n, curr + '(', open + 1, close);
        }
        if (close < open) { // add ')'
            backtrack(n, curr + ')', open, close + 1);
        }
    }
}

/*
---------------------------------
Logic:
1. Backtrack to add '(' and ')' based on counts.
2. Stop when string length is 2*n.
3. Backtrack automatically with recursion.
---------------------------------
Complexity:
- Time: O(4^n / √n)
- Space: O(n)
*/
