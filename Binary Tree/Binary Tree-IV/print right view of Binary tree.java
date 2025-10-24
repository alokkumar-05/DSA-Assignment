/*
Problem Name: Binary Tree Right Side View
Problem Number: LeetCode 199
Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
*/
import java.util.*;
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
    // Function to return the right side view of binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Level-order traversal
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add last node in the current level
                if (i == size - 1) res.add(node.val);

                // Enqueue children
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return res;
    }
}

/*
---------------------------------
Logic:
1. Perform BFS using a queue.
2. Traverse each level of the tree.
3. The last node processed in each level is visible from the right side.
4. Add it to the result list.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(w), where w = max width of tree
*/
