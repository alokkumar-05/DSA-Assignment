
/*
Problem Name: Reverse Linked List
Problem Number: LeetCode 206
Problem Link: https://leetcode.com/problems/reverse-linked-list/
*/


 
  class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  } 
 class Solution {
    public ListNode reverseList(ListNode head) {
        // empty or single-node list
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Fix current node pointers
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        // Return new head of the reversed list
        return newHead;
    }
}

/*
---------------------------------
Logic:
1. Base Case: Return head if list has 0 or 1 node.
2. Recursively reverse the remaining list.
3. Re-link: next node's next points to current node.
4. Break original link by setting head.next = null.
5. Return new head.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
