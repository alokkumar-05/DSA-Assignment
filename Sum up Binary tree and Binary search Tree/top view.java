
import java.util.*;

/*
Problem Name: Top View of Binary Tree
Platform: GFG / LeetCode
Link: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
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
 
 class TopViewBinaryTree {

    public static ArrayList<Integer> topView(Node root) {
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

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

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

    // Helper class for level-order traversal with horizontal distance
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
1. BFS with horizontal distance tracking.
2. Store first node at each hd in a map.
3. Traverse map from minHd to maxHd for top view.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
