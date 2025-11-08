import java.util.*;

class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class PrimsAlgorithm {
    public static int spanningTree(int V, int[][][] adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0)); // start from node 0
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;

            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;

            // Add all adjacent edges
            for (int[] neighbor : adj[node]) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];
                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, edgeWt));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][][] adj = {
            {{1,2}, {3,6}},
            {{0,2}, {2,3}, {3,8}, {4,5}},
            {{1,3}, {4,7}},
            {{0,6}, {1,8}},
            {{1,5}, {2,7}}
        };

        System.out.println("Total weight of MST (Prim’s): " + spanningTree(V, adj));
    }
}
