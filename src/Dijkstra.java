import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    public static long[] shortestPath(Graph graph, int source) {
        long[] dist = new long[graph.nodes + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{source, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int u = (int) current[0];
            long d = current[1];

            if (d != dist[u]) continue;

            for (Edge edge : graph.adjacencyList.get(u)) {
                int v = edge.to;
                long newDist = d + edge.weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new long[]{v, newDist});
                }
            }
        }

        return dist;
    }
}
