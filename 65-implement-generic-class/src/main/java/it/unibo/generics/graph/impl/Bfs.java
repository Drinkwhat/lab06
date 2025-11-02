package it.unibo.generics.graph.impl;

import java.util.*;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.PathAlgorithm;

public class Bfs<T> implements PathAlgorithm<T> {

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
        
        Queue<T> queue = new LinkedList<>();
        Map<T, T> parent = new HashMap<>();
        Set<T> visited = new HashSet<>();
        
        queue.add(source);
        visited.add(source);
        
        while (!queue.isEmpty()) {
            T current = queue.poll();
            Set<T> neighbors = graph.linkedNodes(current);
            
            if (neighbors == null) {
                continue;
            }
            
            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    parent.put(neighbor, current);
                    
                    if (neighbor.equals(target)) {
                        // Ricostruisci il percorso
                        LinkedList<T> path = new LinkedList<>();
                        T step = target;
                        while (step != null) {
                            path.addFirst(step);
                            step = parent.get(step);
                        }
                        return path;
                    }
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return null; // Nessun percorso trovato
    }
}
