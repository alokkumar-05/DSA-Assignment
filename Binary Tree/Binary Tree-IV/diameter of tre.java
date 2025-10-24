

/*
Problem Name: Diameter of Binary Tree
Problem Number: LeetCode 543
Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
*/

 class Solution {
    class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; this.left = left; this.right = right;
    }
  }
    // Function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];  // store the max diameter
        height(root, diameter);
        return diameter[0];
    }

    // Recursive helper to compute height and update diameter
    private int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        // Recursively find height of left and right subtrees
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        // Update diameter: longest path through current node
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/*
---------------------------------
Logic:
1. Diameter = longest path between two nodes.
2. For each node:
   - Compute left and right subtree heights.
   - Update diameter as max of previous diameter or (left + right).
3. Return 1 + max(left, right) for height calculation.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(h)
*/

