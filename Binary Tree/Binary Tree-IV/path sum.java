
/*
Problem Name: Path Sum
Problem Number: LeetCode 112
Problem Link: https://leetcode.com/problems/path-sum/
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
    // Function to check if tree has a path with given sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return checker(root, targetSum, 0);
    }

    // Recursive DFS helper function
    private boolean checker(TreeNode root, int tar, int sum) {
        if (root == null) return false;

        sum += root.val; // accumulate current node value

        // Check if it's a leaf and sum equals target
        if (root.left == null && root.right == null) {
            return sum == tar;
        }

        // Recur for left or right child
        return checker(root.left, tar, sum) || checker(root.right, tar, sum);
    }
}

/*
---------------------------------
Logic:
1. Use DFS to explore all root-to-leaf paths.
2. Maintain running sum of node values.
3. If at a leaf, check if running sum == targetSum.
4. Return true if any path satisfies the condition.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(h)
*/
