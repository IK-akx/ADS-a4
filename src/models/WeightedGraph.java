package models;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private final Set<Vertex<V>> vertices;
    private final boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashSet<>();
    }

    public Set<Vertex<V>> getSet() {
        return vertices;
    }

    public void addVertex(Vertex<V> v) {
        vertices.add(v);
    }

    public void addEdge(Vertex<V> src, Vertex<V> dst, double weight) {
        Vertex<V> source = findOrCreateVertex(src);
        Vertex<V> destination = findOrCreateVertex(dst);

        source.addAdjacentVertex(destination, weight);
        if (!directed) {
            destination.addAdjacentVertex(source, weight);
        }
    }

    private Vertex<V> findOrCreateVertex(Vertex<V> vertex) {
        for (Vertex<V> v : vertices) {
            if (v.equals(vertex)) return v;
        }
        vertices.add(vertex);
        return vertex;
    }
}
