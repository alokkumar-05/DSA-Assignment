
/*
Problem Name: Get Length of a Linked List
Problem Link: https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
*/

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

 class Solution {
    // Function to count nodes in the linked list
    public int getCount(Node head) {
        if (head == null) {
            return 0;
        }

        Node temp = head;
        int length = 0;

        // Traverse each node and count
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }
}

/*
---------------------------------
Logic:
1. Start with head node and initialize count = 0.
2. Move through the list using a pointer.
3. For every node, increment count by 1.
4. Stop when the pointer becomes null.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/