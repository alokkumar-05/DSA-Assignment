
/*
Problem Name: Middle of the Linked List
Problem Number: LeetCode 876
Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
*/


 //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
 class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head; // moves one step
        ListNode fast = head; // moves two steps

        // When fast reaches the end, slow is at middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

/*
---------------------------------
Logic:
1. Use two pointers: slow and fast.
2. Move fast by two nodes and slow by one.
3. When fast reaches the end, slow will be at the middle.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
