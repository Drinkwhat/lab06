package it.unibo.generics.graph.api;

import java.util.List;

public interface PathAlgorithm<T> {
    List<T> getPath(Graph<T> graph, T source, T target);
}
