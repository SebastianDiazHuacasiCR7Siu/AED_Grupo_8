public class Node<T> {
    public T valor;
    public Node<T> siguiente;

    public Node(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
