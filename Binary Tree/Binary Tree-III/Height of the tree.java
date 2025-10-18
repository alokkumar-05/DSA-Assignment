/*
Problem Name: Maximum Depth of Binary Tree
Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
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

 class MaxDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}

/*
---------------------------------
Logic:
1. Use recursion to find max depth of left and right subtree.
2. Return 1 + max(leftDepth, rightDepth) at each node.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(h)
---------------------------------
*/
