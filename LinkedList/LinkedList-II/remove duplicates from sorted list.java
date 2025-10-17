
/*
Problem Name: Remove Duplicates from Sorted List
Problem Number: LeetCode 83
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    // Function to remove duplicates from a sorted linked list
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // Edge case: empty list

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;  // Skip duplicate node
            } else {
                node = node.next;            // Move to next unique node
            }
        }

        return head;
    }
}

/*
---------------------------------
Logic:
1. Iterate through the sorted list.
2. If current node equals next node, skip next node.
3. Otherwise, move to next node.
4. Return modified list.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
