import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int nodes;
    public int edges;
    public List<List<Edge>> adjacencyList;
    public List<Edge> edgeList;

    public Graph(int nodes) {
        this.nodes = nodes;
        this.edges = 0;
        this.adjacencyList = new ArrayList<>();
        this.edgeList = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        Edge edge = new Edge(from, to, weight);
        adjacencyList.get(from).add(edge);
        edgeList.add(edge);
        edges++;
    }
}