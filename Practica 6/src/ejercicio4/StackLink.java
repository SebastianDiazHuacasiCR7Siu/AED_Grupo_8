package ejercicio4;

public class StackLink<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
    }

    public T pop() throws Exception {
        if (isEmpty()) throw new Exception("Pila vacía");
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() throws Exception {
        if (isEmpty()) throw new Exception("Pila vacía");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
