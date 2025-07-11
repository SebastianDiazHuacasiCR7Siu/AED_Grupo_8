package graph;

public class Edge<E> {
    private Vertex<E> refDest;
    private double weight;

    public Edge(Vertex<E> refDest) {
        this(refDest, -1);
    }

    public Edge(Vertex<E> refDest, double weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    public Vertex<E> getRefDest() {
        return refDest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<?> e = (Edge<?>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.weight > -1)
            return refDest.getData() + " [" + this.weight + "], ";
        else
            return refDest.getData() + ", ";
    }
}


