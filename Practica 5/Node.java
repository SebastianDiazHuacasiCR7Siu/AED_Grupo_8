//Nodo generico de lista enlazada
public class Node<T> {
    private T data;   //dato que guarda el nodo de Tipo T
    private Node<T> next; //se apunta al siguiente nodo

    //constructor del nodo, recibe el dato que va a almacenar
    public Node(T data) {
        this.data = data;
        this.next = null; //por defecto el siguiente es null
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}