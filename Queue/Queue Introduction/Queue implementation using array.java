
/*
Problem Name: Circular Queue using Array
Problem Link: Custom Assignment
*/

 class myQueue {
    int front, rear, size, capacity;
    int[] arr;

    // Constructor to initialize queue
    public myQueue(int n) {
        capacity = n;
        arr = new int[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Add element to queue
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + x);
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = x;
        size++;
    }

    // Remove element from queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        front = (front + 1) % capacity; // circular increment
        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
}

/*
---------------------------------
Logic:
1. Queue implemented using array in circular fashion.
2. front and rear move circularly using modulo operator.
3. size tracks current number of elements.
4. Supports O(1) enqueue, dequeue, getFront, getRear.

---------------------------------
Complexity:
- Time Complexity: O(1)
- Space Complexity: O(n)
*/
