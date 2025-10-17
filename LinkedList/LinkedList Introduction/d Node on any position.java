


/*
Problem Name: Design Linked List
Problem Number: LeetCode 707
Problem Link: https://leetcode.com/problems/design-linked-list/
*/

 class MyLinkedList {
    // Node class for singly linked list
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    // Constructor
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at given index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.val;
    }

    // Add new node at head
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add new node at tail
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) head = newNode;
        else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    // Add at a specific index
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) { addAtHead(val); return; }
        if (index == size) { addAtTail(val); return; }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;

        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // Delete at a specific index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) head = head.next;
        else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            curr.next = curr.next.next;
        }
        size--;
    }
}

/*
---------------------------------
Logic:
1. Create a Node class with value and next reference.
2. Maintain head pointer and size counter.
3. Traverse till desired index for insertion/deletion.
4. Handle edge cases for head and tail separately.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
