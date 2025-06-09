package graph;

import listlinked.ListLinked;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;



public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    // Método insertVertex
    public void insertVertex(E data) {
        if (searchVertex(data) == null) {
            Vertex<E> newVertex = new Vertex<>(data);
            listVertex.add(newVertex);
        }
    }

    // Método insertEdge
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> origen = searchVertex(verOri);
        Vertex<E> destino = searchVertex(verDes);
        
        if (origen != null && destino != null) {
            Edge<E> newEdge = new Edge<>(destino);
            origen.listAdj.add(newEdge);
        }
    }

    // Método searchVertex
    private Vertex<E> searchVertex(E data) {
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    // Método searchEdge
    public boolean searchEdge(E v, E z) {
        Vertex<E> vertexV = searchVertex(v);
        Vertex<E> vertexZ = searchVertex(z);

        if (vertexV != null && vertexZ != null) {
            for (Edge<E> edge : vertexV.listAdj) {
                if (edge.getRefDest().equals(vertexZ)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Método removeVertex
    public void removeVertex(E data) {
        Vertex<E> toRemove = searchVertex(data);
        if (toRemove != null) {
            for (Vertex<E> vertex : listVertex) {
                vertex.listAdj.remove(new Edge<>(toRemove));
            }
            listVertex.remove(toRemove);
        }
    }

    // Método removeEdge
    public void removeEdge(E v, E z) {
        Vertex<E> origen = searchVertex(v);
        Vertex<E> destino = searchVertex(z);
        if (origen != null && destino != null) {
            origen.listAdj.remove(new Edge<>(destino));
        }
    }

    // Método dfs (profundidad)
    public void dfs(E startData) {
        Vertex<E> startVertex = searchVertex(startData);
        if (startVertex == null) {
            System.out.println("Vértice no encontrado.");
            return;
        }
        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsVisit(startVertex, visited);
    }

    private void dfsVisit(Vertex<E> current, ListLinked<Vertex<E>> visited) {
        visited.add(current);
        System.out.print(current.getData() + " ");
        for (Edge<E> edge : current.listAdj) {
            Vertex<E> neighbor = edge.getRefDest();
            if (!visited.contains(neighbor)) {
                dfsVisit(neighbor, visited);
            }
        }
    }

    // 01.a) bfs(v): realiza el recorrido en anchura a partir del vértice v 

    public void bfs(E startData) {
        Vertex<E> startVertex = searchVertex(startData);
        if (startVertex == null) {
            System.out.println("Vértice no encontrado.");
            return;
        }

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    // 01.b) bfsPath(v, z): que es la especialización del método bfs()

    public ArrayList<E> bfsPath(E startData, E endData) {
        Vertex<E> startVertex = searchVertex(startData);
        Vertex<E> endVertex = searchVertex(endData);

        if (startVertex == null || endVertex == null) {
            return null;
        }

        Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();

        visited.add(startVertex);
        queue.offer(startVertex);
        parentMap.put(startVertex, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            if (current.equals(endVertex)) {
                break;
            }

            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        // reconstruir camino desde endVertex a startVertex
        ArrayList<E> path = new ArrayList<>();
        Vertex<E> current = endVertex;

        while (current != null && parentMap.containsKey(current)) {
            path.add(0, current.getData());
            current = parentMap.get(current);
        }

        if (path.isEmpty() || !path.get(0).equals(startData)) {
            return null; // no hay camino válido
        }

        return path;
    }

    public String toString() {
        return this.listVertex.toString();
    }

    // a) insertEdgeWeight(v, z, w): inserta una arista del vértice v a z con peso w.
    public void insertEdgeWeight(E v, E z, double w) {
    Vertex<E> origen = searchVertex(v);
    Vertex<E> destino = searchVertex(z);
    if (origen != null && destino != null) {
        origen.listAdj.add(new Edge<>(destino, w));
        destino.listAdj.add(new Edge<>(origen, w)); // No dirigido
    }
    }

    // b) shortPath(v, z): calcula y determina la ruta más corta entre el vértice v y z. La ruta encontrada debe retornarla en un ArrayList.
    public ArrayList<E> shortPath(E v, E z) {
    Vertex<E> start = searchVertex(v);
    Vertex<E> end = searchVertex(z);
    if (start == null || end == null) return null;

    Map<Vertex<E>, Double> dist = new HashMap<>();
    Map<Vertex<E>, Vertex<E>> prev = new HashMap<>();
    Set<Vertex<E>> visited = new HashSet<>();
    PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

    for (Vertex<E> vertex : listVertex) {
        dist.put(vertex, Double.POSITIVE_INFINITY);
    }
    dist.put(start, 0.0);
    queue.add(start);

    while (!queue.isEmpty()) {
        Vertex<E> current = queue.poll();
        if (visited.contains(current)) continue;
        visited.add(current);

        for (Edge<E> edge : current.listAdj) {
            Vertex<E> neighbor = edge.getRefDest();
            double newDist = dist.get(current) + edge.getWeight();
            if (newDist < dist.get(neighbor)) {
                dist.put(neighbor, newDist);
                prev.put(neighbor, current);
                queue.add(neighbor);
            }
        }
    }

    ArrayList<E> path = new ArrayList<>();
    if (!prev.containsKey(end) && !start.equals(end)) return null;

    for (Vertex<E> at = end; at != null; at = prev.get(at)) {
        path.add(0, at.getData());
    }
    return path;
    }

    // c) isConexo(): devuelve true si el grafo es conexo, en caso contrario devuelve false.

    public boolean isConexo() {
    if (listVertex.isEmpty()) return true;

    Vertex<E> startVertex = listVertex.iterator().next(); // obtener el primer vértice
    ListLinked<Vertex<E>> visited = new ListLinked<>();
    dfsVisit(startVertex, visited);

    return visited.size() == listVertex.size();
    }


    // d) Dijsktra(v, w): retorna un stack con la ruta más corta de un vértice v a otro w.
    public Stack<E> Dijkstra(E v, E w) {
    ArrayList<E> path = shortPath(v, w);
    if (path == null) return null;
    Stack<E> stack = new Stack<>();
    for (int i = path.size() - 1; i >= 0; i--) {
        stack.push(path.get(i));
    }
    return stack;
    }
}

