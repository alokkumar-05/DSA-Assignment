import java.util.*;

/*
Problem Name: Binary Tree Level Order Traversal
Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
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

class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(level);
        }

        return res;
    }
}

/*
---------------------------------
Logic:
1. Use BFS with a queue to traverse the tree level by level.
2. Collect node values of each level in a list and add to result.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
