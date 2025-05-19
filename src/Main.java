import models.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillGraph(graph);

        System.out.println("Dijkstra Search from Almaty to Aktobe:");
        Search<String> dijkstra = new DijkstraSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(dijkstra, new Vertex<>("Aktobe"));

        System.out.println("--------------------------------------------------");

        System.out.println("Breadth First Search from Almaty to Aktobe:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(bfs, new Vertex<>("Aktobe"));
    }

    public static void fillGraph(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 2.1);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 7.8);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 7.1);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 7.2);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 3.9);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 3.5);
        graph.addEdge(new Vertex<>("Kostanay"), new Vertex<>("Aktobe"), 4.0);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 5.4);
    }


    public static void outputPath(Search<String> search, Vertex<String> target) {
        var path = search.pathTo(target);

        if (path == null) {
            System.out.println("No path found to " + target);
            return;
        }

        for (Vertex<String> v : path) {
            System.out.print(v + " -> ");
        }

        System.out.println("END\n");
    }
}
