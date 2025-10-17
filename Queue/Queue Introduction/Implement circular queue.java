
import java.util.Arrays;

/*
Problem Name: Design Circular Queue
Problem Number: LeetCode 622
Problem Link: https://leetcode.com/problems/design-circular-queue/
*/

 class MyCircularQueue {
    private int[] q;
    private int front = 0, rear = 0, size = 0;

    // Constructor to initialize queue with given capacity
    public MyCircularQueue(int k) {
        q = new int[k];
        Arrays.fill(q, -1); // Initialize all positions with -1
    }

    // Insert element at rear
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = rear = 0;
            q[rear] = value;
            size++;
            return true;
        }

        rear = (rear + 1) % q.length; // Circular increment
        q[rear] = value;
        size++;
        return true;
    }

    // Remove element from front
    public boolean deQueue() {
        if (isEmpty()) return false;

        q[front] = -1; // Optional: clear value
        front = (front + 1) % q.length;
        size--;
        return true;
    }

    // Get front element
    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    // Get rear element
    public int Rear() {
        return isEmpty() ? -1 : q[rear];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == q.length;
    }
}

/*
---------------------------------
Logic:
1. Use array of fixed size with modular arithmetic for circular behavior.
2. Track size, front, and rear indices.
3. enQueue → add element, move rear forward.
4. deQueue → remove front, move front forward.
5. Maintain O(1) operations using modulo.

---------------------------------
Complexity:
- Time Complexity: O(1)
- Space Complexity: O(k)
*/
