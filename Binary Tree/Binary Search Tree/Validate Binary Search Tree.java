
/*
Problem Name: Validate Binary Search Tree
Problem Number: LeetCode 98
Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
*/
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; this.left = left; this.right = right;
    }
}

class Solution {

    // Check whether the binary tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Recursive helper function
    private boolean isValid(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;

        // Check if current node violates BST property
        if (root.val <= minVal || root.val >= maxVal) return false;

        // Check subtrees recursively with updated bounds
        return isValid(root.left, minVal, root.val) &&
               isValid(root.right, root.val, maxVal);
    }
}

/*
---------------------------------
Logic:
1. Use recursion with range constraints.
2. Each node must be:
   left < node.val < right.
3. Update bounds while going down:
   - Left subtree upper bound → current node value
   - Right subtree lower bound → current node value
4. Return false immediately if any violation occurs.
---------------------------------
Complexity:
Time: O(n)
Space: O(h) where h = height of tree
---------------------------------
*/
