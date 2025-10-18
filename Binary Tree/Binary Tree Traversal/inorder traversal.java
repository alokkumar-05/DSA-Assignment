

import java.util.*;

/*
Problem Name: Binary Tree Inorder Traversal
Problem Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
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

 class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private static void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }

}

/*
---------------------------------
Logic:
1. Use recursion to traverse left → root → right.
2. Add node values to list during traversal.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
