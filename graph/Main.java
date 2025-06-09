package graph;

import java.util.ArrayList;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        GraphLink<Integer> graph = new GraphLink<>();

        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertVertex(5);

        // Insertar aristas
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 5);

        // Mostrar grafo
        System.out.println("Grafo:");
        System.out.println(graph);

        // Buscar arista
        System.out.println("¿Existe arista entre 1 y 2? " + graph.searchEdge(1, 2));
        System.out.println("¿Existe arista entre 2 y 5? " + graph.searchEdge(2, 5));

        // Recorrido en profundidad 
        System.out.println("Recorrido en profundidad desde vértice 1:");
        graph.dfs(1);

        // Recorrido en anchura desde vértice 1
        System.out.println("\n\nRecorrido en anchura desde vértice 1:");
        graph.bfs(1);

        // Camino desde 1 hasta 5 usando BFS
        System.out.println("\n\nCamino más corto desde 1 hasta 5 (bfsPath):");
        ArrayList<Integer> path = graph.bfsPath(1, 5);
        if (path != null) {
            System.out.println("Camino encontrado: " + path);
        } else {
            System.out.println("No existe camino entre 1 y 5.");
        }
        
        // Camino más corto usando Dijkstra
        System.out.println("\nCamino más corto desde 1 hasta 5 (Dijkstra):");
        Stack<Integer> stackPath = graph.Dijkstra(1, 5);
        if (stackPath != null && !stackPath.isEmpty()) {
        while (!stackPath.isEmpty()) {
        System.out.print(stackPath.pop());
        if (!stackPath.isEmpty()) System.out.print(" -> ");
        }
            System.out.println();
        } else {
        System.out.println("No existe ruta entre los vértices.");
}


        // Eliminar arista
        graph.removeEdge(1, 2);
        System.out.println("\nDespués de eliminar la arista (1 -> 2):");
        System.out.println(graph);

        // Eliminar vértice
        graph.removeVertex(4);
        System.out.println("Después de eliminar el vértice 4:");
        System.out.println(graph);
    }
}




