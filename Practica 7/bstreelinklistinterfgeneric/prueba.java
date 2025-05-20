package bstreelinklistinterfgeneric;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public class prueba {

    public static boolean sameArea(LinkedBST<?> a, LinkedBST<?> b) {
        return a.areaBST() == b.areaBST();
    }

    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        try {
            // Insertar nodos
            arbol.insert(400);
            arbol.insert(100);
            arbol.insert(700);
            arbol.insert(50);
            arbol.insert(200);
            arbol.insert(75);

            // Mostrar el árbol
            System.out.println("Árbol:");
            arbol.drawBST();  // usa toString()

            // Recorridos
            System.out.print("InOrder: ");
            arbol.printInOrder();    // 50 75 100 200 400 700

            System.out.print("PreOrder: ");
            arbol.printPreOrder();   // 400 100 50 75 200 700

            System.out.print("PostOrder: ");
            arbol.printPostOrder();  // 75 50 200 100 700 400

            // Mínimo y máximo
            System.out.println("\nValor mínimo: " + arbol.obtenerMinimo());
            System.out.println("Valor máximo: " + arbol.obtenerMaximo());

            // Conteo de nodos
            System.out.println("Total de nodos: " + arbol.countAllNodes());
            System.out.println("Nodos no hoja: " + arbol.countNodes());

            // Altura de un nodo
            int valorAltura = 100;
            System.out.println("Altura del subárbol con raíz en " + valorAltura + ": " + arbol.height(valorAltura));

            // Amplitud en un nivel
            int nivel = 2;
            System.out.println("Amplitud en el nivel " + nivel + ": " + arbol.amplitude(nivel));

            // Área del árbol
            System.out.println("Área del árbol: " + arbol.areaBST());

            // Comparación con otro árbol
            LinkedBST<Integer> otroArbol = new LinkedBST<>();
            otroArbol.insert(300);
            otroArbol.insert(150);
            otroArbol.insert(450);
            otroArbol.insert(100);
            otroArbol.insert(200);
            otroArbol.insert(50);

            System.out.println("¿Los árboles tienen la misma área? " + sameArea(arbol, otroArbol));

            // Destruir árbol
            arbol.destroyNodes();
            System.out.println("Árbol destruido. ¿Está vacío? " + (arbol.countAllNodes() == 0));

        } catch (ItemDuplicated | ItemNoFound e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}

