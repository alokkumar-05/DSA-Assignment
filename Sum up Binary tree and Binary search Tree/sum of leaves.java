
/*
Problem Name: Sum of Left Leaves
Platform: LeetCode / GFG
Link: https://leetcode.com/problems/sum-of-left-leaves/
*/
  class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left=null;
        this.right=null;
    }
  }

 class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // Add left leaf value if exists
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // Recur for left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}

/*
---------------------------------
Logic:
1. Check if left child is a leaf; add its value.
2. Recursively traverse left and right subtrees.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(h) recursion stack
*/

