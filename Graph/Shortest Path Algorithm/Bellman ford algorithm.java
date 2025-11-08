import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
 class BellmanFordAlgorithm {

    public static void bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        //  Relax all edges (V - 1) times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge e : edges) {
            int u = e.src;
            int v = e.dest;
            int wt = e.weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println(i + " : INF");
            else
                System.out.println(i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();

        // Add directed edges: src, dest, weight
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        bellmanFord(V, edges, 0);
    }
}
