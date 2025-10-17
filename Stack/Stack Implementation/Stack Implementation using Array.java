
/*
Problem Name: Implement Stack using Arrays

*/

class Stack {
    private static final int STACK_CAPACITY = 101;
    private char[] stackArray = new char[STACK_CAPACITY];
    private int topIndex = -1;

    void push(char character) {
        // If stack is full (check using isFull function)
        // Then print "Stack is full"
        // Otherwise add the next element at topIndex + 1 and update topIndex
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stackArray[++topIndex] = character; // increment topIndex and insert
        }
    }

    char pop() {
        // If the stack is empty (check using isEmpty function)
        // Then print "Stack is empty" and return '-1'
        // Otherwise return the element at the topIndex
        // But reduce topIndex before returning the element
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return (char)-1;
        } else {
            return stackArray[topIndex--]; // return top element and decrement topIndex
        }
    }

    boolean isEmpty() {
        return topIndex == -1;
    }

    boolean isFull() {
        return topIndex >= STACK_CAPACITY - 1;
    }
}

 class ReverseString {
    public static void main(String[] args) {
        String inputString = "Hello, World!";
        int inputLength = inputString.length();

        Stack charStack = new Stack();

        // Push each character onto the stack
        for (int i = 0; i < inputLength; i++) {
            charStack.push(inputString.charAt(i));
        }

        // Pop the characters from the stack to construct the reversed string
        StringBuilder reversedString = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversedString.append(charStack.pop());
        }

        System.out.println(reversedString.toString());
    }
}

/*
---------------------------------
Logic:
1. Create custom stack with push, pop, isEmpty, isFull.
2. Push each character of input string to stack.
3. Pop characters until stack empty to build reversed string.
4. Print reversed string.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

