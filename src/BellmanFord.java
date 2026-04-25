import java.util.Arrays;

public class BellmanFord {
    public static long[] shortestPath(Graph graph, int source) {
        long[] dist = new long[graph.nodes + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i <= graph.nodes - 1; i++) {
            boolean changed = false;

            for (Edge edge : graph.edgeList) {
                if (dist[edge.from] == Long.MAX_VALUE) continue;

                long newDist = dist[edge.from] + edge.weight;

                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    changed = true;
                }
            }

            if (!changed) break;
        }

        return dist;
    }
}