package btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    private static int idCounter = 0;
    public final int idNode;

    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    protected BNode<E> parent;

    public BNode(int n) {
        this.idNode = ++idCounter;
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        this.count = 0;

        for (int i = 0; i < n; i++) this.keys.add(null);
        for (int i = 0; i <= n; i++) this.childs.add(null);
    }

    //Ver su el nodo actual está lleno
    public boolean nodeFull(int order) {
        return count == order - 1;
    }

    //Ver si el nodo actual está vacio
    public boolean nodeEmpty() {
        return count == 0;
    }

    //Busca una clave en el nodo actual, si la encuentra devuelve verdadero y la posición donde se encuentra, en caso contrario devuelve falso y //la posición del hijo donde debe descender.
    public SearchResult searchNode(E key) {
        int i = 0;
        while (i < count && keys.get(i).compareTo(key) < 0) i++;
        if (i < count && keys.get(i).compareTo(key) == 0)
            return new SearchResult(true, i);
        else
            return new SearchResult(false, i);
    }

    public BNode<E> getParent() {
        return parent;
    }

    public void setParent(BNode<E> parent) {
        this.parent = parent;
    }

    //Retornar la clave encontrada en el nodo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ID: ").append(idNode).append(" - Keys: [");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static class SearchResult {
        public boolean found;
        public int position;

        public SearchResult(boolean found, int position) {
            this.found = found;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Found: " + found + ", Position: " + position;
        }
    }
}


