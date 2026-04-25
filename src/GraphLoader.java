import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphLoader {

    public static Graph loadDIMACS(String filePath) {
        Graph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("c")) {
                    continue;
                }

                if (line.startsWith("p")) {
                    String[] parts = line.split("\\s+");
                    int nodes = Integer.parseInt(parts[2]);
                    graph = new Graph(nodes);
                }

                else if (line.startsWith("a")) {
                    String[] parts = line.split("\\s+");

                    int from = Integer.parseInt(parts[1]);
                    int to = Integer.parseInt(parts[2]);
                    int weight = Integer.parseInt(parts[3]);

                    graph.addEdge(from, to, weight);
                }
            }

        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }

        return graph;
    }
}