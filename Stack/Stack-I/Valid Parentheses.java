
/*
Problem Name: Valid Parentheses
Problem Number: LeetCode 20
Problem Link: https://leetcode.com/problems/valid-parentheses/
*/

import java.util.Stack;

class Solution {
    // Function to check if parentheses string is valid
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Push opening brackets onto stack
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // If stack empty when expecting a match, return false
                if (st.isEmpty()) return false;

                char top = st.pop();
                // Check if current closing bracket matches top of stack
                if ((top == '(' && ch != ')') || 
                    (top == '{' && ch != '}') || 
                    (top == '[' && ch != ']')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets matched
        return st.isEmpty();
    }
}

/*
---------------------------------
Logic:
1. Traverse string using stack to track opening brackets.
2. Match each closing bracket with top of stack.
3. Return true if stack is empty after processing, else false.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

