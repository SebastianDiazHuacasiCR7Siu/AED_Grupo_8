import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de enteros para List<T>
        List<Integer> numeros = Arrays.asList(1, 3, 5, 7, 9);

        System.out.println("¿Contiene 7? " + UtilidadesLista.buscarElemento(numeros, 7));
        System.out.println("Lista invertida: " + UtilidadesLista.invertirLista(numeros));

        // Creacion de lista enlazada: 
        Node<Integer> lista1 = null;
        lista1 = ListaEnlazadaOperaciones.insertarAlFinal(lista1, 1);
        lista1 = ListaEnlazadaOperaciones.insertarAlFinal(lista1, 2);
        lista1 = ListaEnlazadaOperaciones.insertarAlFinal(lista1, 3);

        System.out.println("Nodos en primera lista : " + ListaEnlazadaOperaciones.contarNodos(lista1));

        // Creacion de segunda lista con mismos valores
        Node<Integer> lista2 = new Node<>(1);
        lista2.siguiente = new Node<>(2);
        lista2.siguiente.siguiente = new Node<>(3);

        System.out.println("¿lista1 y lista2 son iguales? " + ListaEnlazadaOperaciones.sonIguales(lista1, lista2));

        // Concatenar primera lista con otra lista
        Node<Integer> otra = new Node<>(4);
        otra.siguiente = new Node<>(5);
        Node<Integer> listaConcatenada = ListaEnlazadaOperaciones.concatenarListas(lista1, otra);

        System.out.print("Lista concatenada: ");
        while (listaConcatenada != null) {
            System.out.print(listaConcatenada.valor + " ");
            listaConcatenada = listaConcatenada.siguiente;
        }
    }
}
