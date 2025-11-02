package it.unibo.generics.graph.api;

/**
 * A simple generic node implementation.
 *
 * @param <T>
 *            the type of value the node contains
 */
public class Node<T> {
    private final T value;

    /**
     * Constructs a node with the given value.
     *
     * @param value
     *            the value, must not be null
     * @throws IllegalArgumentException
     *             if value is null
     */
    public Node(final T value) {
        if (value == null) {
            throw new IllegalArgumentException("Node's value cannot be null");
        }
        this.value = value;
    }

    /**
     * @return the value of this node
     */
    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node<?> other = (Node<?>) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
