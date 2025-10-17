
/*
Problem Name: Add Two Numbers
Problem Number: LeetCode 2
Problem Link: https://leetcode.com/problems/add-two-numbers/
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
    // Function to add two numbers represented as linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node for result
        ListNode current = dummy;          // Pointer for result list
        int carry = 0;                     // Carry for sums >= 10

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;              // Carry for next iteration

            current.next = new ListNode(sum % 10);  // Create new node
            current = current.next;

            if (l1 != null) l1 = l1.next;  // Move to next node
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}

/*
---------------------------------
Logic:
1. Initialize a dummy node to simplify list creation.
2. Traverse both linked lists, summing corresponding digits and carry.
3. Create a new node for each resulting digit.
4. Continue until both lists and carry are processed.

---------------------------------
Complexity:
- Time Complexity: O(max(n, m))
- Space Complexity: O(max(n, m))
*/

