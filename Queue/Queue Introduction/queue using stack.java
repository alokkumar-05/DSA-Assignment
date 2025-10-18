
import java.util.Stack;

/*
Problem Name: Implement Queue using Stacks
Problem Number: LeetCode 232
Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/
*/

 class MyQueue {
    private Stack<Integer> input;  // Stack for enqueue
    private Stack<Integer> output; // Stack for dequeue
    private int peekEl;            // Track the front element

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
        peekEl = -1;
    }

    // Push element to the back of the queue
    public void push(int x) {
        if (input.empty()) {
            peekEl = x; // Update front tracker if queue is empty
        }
        input.push(x);
    }

    // Remove the element from the front of the queue
    public int pop() {
        // If output is empty, move elements from input
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    // Get the front element
    public int peek() {
        // If output has elements, its top is the front
        if (output.empty()) {
            return peekEl;
        }
        return output.peek();
    }

    // Check if the queue is empty
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/*
---------------------------------
Logic:
1. Use two stacks: input (for push) and output (for pop).
2. On pop: if output empty, transfer all from input to output.
3. On peek: return top of output or front tracker.
4. On empty: both stacks must be empty.

---------------------------------
Complexity:
- Push: O(1)
- Pop: Amortized O(1)
- Peek: O(1)
- Space: O(n)
*/
