package models;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
        dijkstra(graph, graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
    }

    private void dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<V> vertex : graph.getSet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);
        queue.add(source);
        path.put(source, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double edgeWeight = neighborEntry.getValue();
                double newDistance = distances.get(current) + edgeWeight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    path.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
