
import java.util.Stack;

/*
Problem Name: Evaluate Postfix Expression
Problem Link: https://www.geeksforgeeks.org/evaluation-of-postfix-expression/
*/

 class Solution {
    // Function to evaluate postfix expression given as array of tokens
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {
            // If token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") ||
                token.equals("/") || token.equals("^")) {

                int b = st.pop(); // second operand
                int a = st.pop(); // first operand
                int res = 0;

                // Perform operation based on operator
                switch(token) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = (int)Math.floor((double)a / b); break;
                    case "^": res = (int)Math.pow(a, b); break;
                }

                st.push(res);
            } else {
                // Operand, push to stack
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop(); // final result
    }
}

/*
---------------------------------
Logic:
1. Use stack to store operands.
2. For each token:
   - Push operand.
   - Pop two operands and apply operator if token is operator.
3. Return final value from stack.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

