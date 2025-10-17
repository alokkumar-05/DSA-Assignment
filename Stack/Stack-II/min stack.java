
import java.util.Stack;

/*
Problem Name: Min Stack
Problem Number: LeetCode 155
Problem Link: https://leetcode.com/problems/min-stack/
*/

 class MinStack {

    private Stack<Integer> mainStack; // Stores all elements
    private Stack<Integer> minStack;  // Stores minimum elements

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    // Push element onto stack
    public void push(int val) {
        mainStack.push(val);
        // If new value <= current min, also push to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    // Pop element from stack
    public void pop() {
        int removed = mainStack.pop();
        // Remove from minStack if it's the current min
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    // Return top element
    public int top() {
        return mainStack.peek();
    }
    
    // Return current minimum
    public int getMin() {
        return minStack.peek();
    }
}

/*
---------------------------------
Logic:
1. Use two stacks:
   - mainStack → stores all values.
   - minStack → stores minimums at each level.
2. On push → add to both if it's a new min.
3. On pop → remove from both if top equals current min.
4. getMin() → return top of minStack.

---------------------------------
Complexity:
- Time Complexity: O(1)
- Space Complexity: O(n)
*/

