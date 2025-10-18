import java.util.*;

/*
Problem Name: Same Tree
Problem Link: https://leetcode.com/problems/same-tree/
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

 class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preorder(list1, p);
        preorder(list2, q);

        return list1.equals(list2);
    }

    private static void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
}

/*
---------------------------------
Logic:
1. Preorder traverse both trees, including null markers.
2. Compare the two traversal lists.
3. If identical, trees are the same.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
