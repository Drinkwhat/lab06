package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<T> implements Graph<T> {
    private final Set<T> nodes = new HashSet<>();
    private final Map<T, Set<T>> edges = new HashMap<>();

    @Override
    public void addNode(T node) {
        if (node == null) throw new IllegalArgumentException("Node's value cannot be null");
        nodes.add(node);
        edges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(T source, T target) {
        if (source == null || target == null) throw new IllegalArgumentException("Nodes' values cannot be null");

        if (!nodes.contains(source) || !nodes.contains(target)) throw new IllegalArgumentException("Both nodes must be in the graph");

        edges.get(source).add(target);
    }

    @Override
    public Set<T> nodeSet() {
        return new HashSet<>(nodes);
    }

    @Override
    public Set<T> linkedNodes(T node) {
        if (node == null) throw new IllegalArgumentException("Node's value cannot be null");

        if (!nodes.contains(node)) throw new IllegalArgumentException("Node must be in the graph");

        return new HashSet<>(edges.getOrDefault(node, new HashSet<>()));
    }

    @Override
    public List<T> getPath(T source, T target) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
    
}
