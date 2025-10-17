/*
Problem Name: Merge Two Sorted Lists
Problem Number: LeetCode 21
Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
*/

 class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Choose smaller node and recursively merge remaining nodes
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/*
---------------------------------
Logic:
1. If any list is null, return the other.
2. Compare the values of both list heads.
3. Attach the smaller node to the result and recursively merge the rest.
4. Recursion builds the sorted merged list automatically.

---------------------------------
Complexity:
- Time Complexity: O(n + m)
- Space Complexity: O(n + m)
*/
