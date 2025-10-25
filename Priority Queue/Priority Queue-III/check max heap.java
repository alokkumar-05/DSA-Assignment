
import java.util.*;

/*
Problem Name: Check if Binary Tree is a Heap
Platform: GeeksforGeeks
Link: https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
*/

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
 class CheckIfBinaryTreeIsHeap {

    public static boolean isHeap(Node tree) {
        if (tree == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(tree);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left != null) {
                if (curr.data < curr.left.data) return false;
                if (nullFound) return false;
                q.add(curr.left);
            } else nullFound = true;

            if (curr.right != null) {
                if (curr.data < curr.right.data) return false;
                if (nullFound) return false;
                q.add(curr.right);
            } else nullFound = true;
        }

        return true;
    }
}

/*
---------------------------------
Logic:
1. Perform Level Order Traversal.
2. Check Max-Heap property (parent >= child).
3. Ensure tree completeness (no non-null child after nullFound = true).
---------------------------------
Complexity:
- Time: O(N)
- Space: O(N)
*/
