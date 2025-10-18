

import java.util.*;

/*
Problem Name: Binary Tree Preorder Traversal
Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
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

 class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorderHelper(root, res);
        return res;
    }

    private static void preorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorderHelper(root.left, res);
        preorderHelper(root.right, res);
    }
}

/*
---------------------------------
Logic:
1. Use recursion to traverse root → left → right.
2. Add node values to list during traversal.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
