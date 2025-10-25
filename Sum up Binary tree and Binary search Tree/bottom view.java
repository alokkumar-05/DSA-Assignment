
import java.util.*;

/*
Problem Name: Bottom View of Binary Tree
Platform: GFG / LeetCode
Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/
class Node{
    int data;
    Node left ;
    Node right;
    Node(int data){
        this.data = data;
        this.left=null;
        this.right=null;
    }
  }
 class BottomViewBinaryTree {

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int minHd = 0, maxHd = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            map.put(hd, node.data); // overwrite bottom-most node

            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        for (int i = minHd; i <= maxHd; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }


}

/*
---------------------------------
Logic:
1. BFS with horizontal distance.
2. Overwrite map for bottom-most node at each hd.
3. Traverse map from minHd to maxHd for bottom view.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
