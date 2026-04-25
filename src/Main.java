public class Main {
    public static void main(String[] args) {
        String filePath = "data/USA-road-d.FLA.gr";

        Graph graph = GraphLoader.loadDIMACS(filePath);

        if (graph == null) {
            System.out.println("Graph could not be loaded.");
            return;
        }

        System.out.println("Graph loaded successfully.");
        System.out.println("Nodes: " + graph.nodes);
        System.out.println("Edges: " + graph.edges);

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();
        long dijkstraMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.currentTimeMillis();
        long[] distances = Dijkstra.shortestPath(graph, 1);
        long endTime = System.currentTimeMillis();

        long dijkstraMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long dijkstraMemoryUsed = (dijkstraMemoryAfter - dijkstraMemoryBefore) / (1024 * 1024);

        System.out.println("Dijkstra runtime: " + (endTime - startTime) + " ms");
        System.out.println("Dijkstra memory used: " + dijkstraMemoryUsed + " MB");
        System.out.println("Distance to node 10: " + distances[10]);

        runtime.gc();
        long bfMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        long bfStartTime = System.currentTimeMillis();
        long[] bfDistances = BellmanFord.shortestPath(graph, 1);
        long bfEndTime = System.currentTimeMillis();

        long bfMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long bfMemoryUsed = (bfMemoryAfter - bfMemoryBefore) / (1024 * 1024);

        System.out.println("Bellman-Ford runtime: " + (bfEndTime - bfStartTime) + " ms");
        System.out.println("Bellman-Ford memory used: " + bfMemoryUsed + " MB");
        System.out.println("Bellman-Ford distance to node 10: " + bfDistances[10]);

        if (distances[10] == bfDistances[10]) {
            System.out.println("Both algorithms give the same result.");
        } else {
            System.out.println("Results are different!");
        }
    }
}