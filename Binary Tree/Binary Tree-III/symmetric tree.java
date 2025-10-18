/*
Problem Name: Symmetric Tree
Problem Link: https://leetcode.com/problems/symmetric-tree/
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

 class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right)  && isMirror(t1.right, t2.left);
    }
}

/*
---------------------------------
Logic:
1. Use recursion to compare left and right subtrees.
2. Both null -> symmetric; one null -> false.
3. Values must match and children must be mirrors.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(h)
---------------------------------
*/
