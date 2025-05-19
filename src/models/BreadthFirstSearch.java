package models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
        bfs(graph, graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(source);
        path.put(source, null);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    path.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
