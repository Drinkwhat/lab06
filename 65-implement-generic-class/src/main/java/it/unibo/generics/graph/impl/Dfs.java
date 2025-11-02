package it.unibo.generics.graph.impl;

import java.util.*;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.PathAlgorithm;

public class Dfs<T> implements PathAlgorithm<T> {

    @Override
    public List<T> getPath(Graph<T> graph, T source, T target) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null");
        }
        if (source == null) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }
        if (!graph.nodeSet().contains(source)) {
            throw new IllegalArgumentException("Source node is not in the graph");
        }
        if (!graph.nodeSet().contains(target)) {
            throw new IllegalArgumentException("Target node is not in the graph");
        }
        if (source.equals(target)) {
            return List.of(source);
        }
        
        List<T> path = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        
        if (dfs(graph, source, target, visited, path)) {
            return path;
        }
        return null; // Nessun percorso trovato
    }

    private boolean dfs(Graph<T> graph, T current, T target, Set<T> visited, List<T> path) {
        visited.add(current);
        path.add(current);
        
        if (current.equals(target)) {
            return true;
        }
        
        Set<T> neighbors = graph.linkedNodes(current);
        if (neighbors != null) {
            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (dfs(graph, neighbor, target, visited, path)) {
                        return true;
                    }
                }
            }
        }
        
        path.remove(path.size() - 1);
        return false;
    }
}
