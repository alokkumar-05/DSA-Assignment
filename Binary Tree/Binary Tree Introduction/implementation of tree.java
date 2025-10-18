
import java.util.*;

/*
Problem Name: Create Binary Tree from Descriptions
Problem Link: https://leetcode.com/problems/create-binary-tree-from-descriptions/
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

 class CreateBinaryTreeFromDescriptions {

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0], childVal = desc[1], isLeft = desc[2];
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft == 1) parent.left = child;
            else parent.right = child;

            children.add(childVal);
        }

        for (int val : map.keySet()) {
            if (!children.contains(val)) return map.get(val);
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] desc = {{1,2,1},{1,3,0},{2,4,1}};
        TreeNode root = createBinaryTree(desc);
        System.out.println("Root value: " + root.val); // Output: 1
    }
}

/*
---------------------------------
Logic:
1. Map values to TreeNodes.
2. Track all children in a HashSet.
3. Link parent and child according to isLeft.
4. Return root (node not present in children set).
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
