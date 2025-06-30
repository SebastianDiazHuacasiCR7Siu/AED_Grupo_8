package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();

        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insertar aristas con pesos
        graph.insertEdgeWeight("A", "B", 2);
        graph.insertEdgeWeight("A", "C", 4);
        graph.insertEdgeWeight("B", "D", 3);
        graph.insertEdgeWeight("C", "D", 1);
        graph.insertEdgeWeight("D", "E", 5);

        System.out.println("Grafo: " + graph);

        // Recorrido DFS
        System.out.print("DFS desde A: ");
        graph.dfs("A");
        System.out.println();

        // Recorrido BFS
        System.out.print("BFS desde A: ");
        graph.bfs("A");
        System.out.println();

        // Ruta más corta de A a E (Dijkstra)
        Stack<String> path = graph.Dijkstra("A", "E");
        if (path != null) {
            System.out.println("Ruta más corta de A a E (Dijkstra): " + path);
        } else {
            System.out.println("No hay ruta de A a E.");
        }

        // Verificar si es conexo
        System.out.println("¿Es conexo? " + graph.isConexo());

        // Verificar tipo de grafo
        System.out.println("¿Es ciclo? " + graph.esCiclo());
        System.out.println("¿Es camino? " + graph.esCamino());
        System.out.println("¿Es rueda? " + graph.esRueda());
        System.out.println("¿Es completo? " + graph.esCompleto());

        // Buscar ruta por BFS
        ArrayList<String> bfsPath = graph.bfsPath("A", "E");
        if (bfsPath != null) {
            System.out.println("Camino de A a E (BFS): " + bfsPath);
        } else {
            System.out.println("No se encontró camino de A a E con BFS.");
        }

        // Obtener grado de un nodo
        System.out.println("Grado del nodo D: " + graph.gradoNodo("D"));
    }
}




