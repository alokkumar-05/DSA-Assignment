

/*
Problem Name: Rotate List
Problem Number: LeetCode 61
Problem Link: https://leetcode.com/problems/rotate-list/
*/


 // Definition for singly-linked list.
  class ListNode {
      int val;
    ListNode next;
       ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 } 
 
class Solution {
    // Function to rotate a linked list right by k positions
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Compute length of list
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Connect tail to head to form a circle
        tail.next = head;

        // Effective rotations if k > n
        k = k % n;
        int stepsToNewTail = n - k - 1;

        // Find new tail and head
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}

/*
---------------------------------
Logic:
1. Handle trivial cases (null, single node, k=0)
2. Compute length and make list circular
3. Determine new tail and head
4. Break circle and return new head

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

