public class ListaEnlazadaOperaciones {

    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo;
        Node<T> actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        return head;
    }

    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        while (head != null) {
            contador++;
            head = head.siguiente;
        }
        return contador;
    }

    public static <T> boolean sonIguales(Node<T> l1, Node<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.valor.equals(l2.valor)) return false;
            l1 = l1.siguiente;
            l2 = l2.siguiente;
        }
        return l1 == null && l2 == null;
    }

    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        Node<T> actual = l1;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = l2;
        return l1;
    }
}
