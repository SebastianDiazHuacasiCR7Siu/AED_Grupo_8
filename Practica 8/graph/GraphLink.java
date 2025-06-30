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

    // bfs(v): realiza el recorrido en anchura a partir del vértice v 

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

    // bfsPath(v, z): que es la especialización del método bfs

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

        // a) Obtener el grado de un nodo
    public int gradoNodo(E data) {
    Vertex<E> vertex = searchVertex(data);
    if (vertex == null) return -1;
    return vertex.listAdj.size();
}

    // b) Verifica si el grafo es un camino (Px)
    public boolean esCamino() {
    int countGrado1 = 0;
    int countGrado2 = 0;

    for (Vertex<E> vertex : listVertex) {
        int grado = vertex.listAdj.size();
        if (grado == 1) {
            countGrado1++;
        } else if (grado == 2) {
            countGrado2++;
        } else {
            return false;
        }
    }

    return countGrado1 == 2 && (countGrado1 + countGrado2) == listVertex.size();
}

    // c) Verifica si el grafo es un ciclo (Cx)
    public boolean esCiclo() {
    for (Vertex<E> vertex : listVertex) {
        if (vertex.listAdj.size() != 2) return false;
    }
    return isConexo();
}

    // d) Verifica si el grafo es una rueda (Wx)
    public boolean esRueda() {
    int n = listVertex.size();
    int centro = -1;
    int cicloCount = 0;

    for (Vertex<E> vertex : listVertex) {
        int grado = vertex.listAdj.size();
        if (grado == n - 1) {
            if (centro != -1) return false; // solo debe haber un vértice con grado n-1
            centro = 1;
        } else if (grado == 3 || grado == 2) {
            cicloCount++;
        } else {
            return false;
        }
    }

    return centro == 1 && cicloCount == n - 1;
}

    // e) Verifica si el grafo es completo (Kx)
    public boolean esCompleto() {
    int n = listVertex.size();
    for (Vertex<E> vertex : listVertex) {
        if (vertex.listAdj.size() != n - 1) {
            return false;
        }
    }
    return true;
}
// Método para verificar si dos grafos son isomorfos 
public boolean isIsomorfo(GraphLink<E> other) {
    if (this.listVertex.size() != other.listVertex.size()) return false;
    ArrayList<Integer> deg1 = new ArrayList<>(), deg2 = new ArrayList<>();
    for (Vertex<E> v : this.listVertex) deg1.add(v.listAdj.size());
    for (Vertex<E> v : other.listVertex) deg2.add(v.listAdj.size());
    deg1.sort(Integer::compareTo); deg2.sort(Integer::compareTo);
    return deg1.equals(deg2);
}

// Método para verificar si el grafo es plano 
public boolean isPlano() {
    int V = listVertex.size(), A = 0;
    for (Vertex<E> v : listVertex) A += v.listAdj.size();
    return A <= (3 * V - 6);
}

// Método para verificar si el grafo es fuertemente conexo
public boolean isFuertementeConexo() {
    for (Vertex<E> v : listVertex) {
        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsVisit(v, visited);
        if (visited.size() != listVertex.size()) return false;
    }
    return true;
}

// Método para verificar si el grafo es auto-complementario
public boolean isAutoComplementario() {
    GraphLink<E> comp = new GraphLink<>();
    for (Vertex<E> v : listVertex) comp.insertVertex(v.getData());
    for (Vertex<E> v : listVertex) {
        for (Vertex<E> w : listVertex) {
            if (!v.equals(w) && !searchEdge(v.getData(), w.getData())) {
                comp.insertEdge(v.getData(), w.getData());
            }
        }
    }
    return this.isIsomorfo(comp);
}


}

