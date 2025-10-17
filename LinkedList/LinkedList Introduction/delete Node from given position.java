
/*
Problem Name: Delete Node in a Linked List
Problem Number: LeetCode 237
Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
*/

/**
 * Definition for singly-linked list.*/
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 

 class Solution {
    // Deletes the given node without access to head
    public void deleteNode(ListNode node) {
      // Keep shifting values until the last node
        ListNode prev = null;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        // Remove the last duplicate node
        if (prev != null) {
            prev.next = null;
        }
    }
}

/*
---------------------------------
Logic:
1. Copy the next node’s value into the current node.
2. Skip the next node by changing current.next to next.next.
3. This effectively deletes the given node without using head reference.

---------------------------------
Complexity:
- Time Complexity: O(1)
- Space Complexity: O(1)
*/
