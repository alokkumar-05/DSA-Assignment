import java.util.*;

class Pair {
    int node;
    int dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

 class DijkstraAlgorithm {
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        //  Distance array initialized with infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        //  Min-heap for selecting minimum distance node
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(S, 0));

        //  Standard Dijkstra loop
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int distance = current.dist;

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges: u -> v with weight
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 1)));

        int[] result = dijkstra(V, adj, 0);
        System.out.println("Shortest distances from source 0:");
        System.out.println(Arrays.toString(result));
    }
}
