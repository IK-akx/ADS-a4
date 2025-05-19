package models;

import java.util.*;

public abstract class Search<V> {
    protected final Vertex<V> source;
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>, Vertex<V>> path;

    public Search(Vertex<V> source) {
        this.source = source;
        this.visited = new HashSet<>();
        this.path = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return visited.contains(v);
    }

    public List<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex<V>> result = new LinkedList<>();
        for (Vertex<V> current = v; current != null; current = path.get(current)) {
            result.push(current);
        }

        return result;
    }
}
