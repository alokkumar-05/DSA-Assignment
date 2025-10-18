

import java.util.*;

/*
Problem Name: Binary Tree Postorder Traversal
Problem Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
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
 class PostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}

/*
---------------------------------
Logic:
1. Use recursion to traverse left → right → root.
2. Add node values to list during traversal.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
