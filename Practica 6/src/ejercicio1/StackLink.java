package ejercicio1;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public T pop() throws ExcepcionIsEmpty {
        if (isEmpty()) {
            throw new ExcepcionIsEmpty("La pila está vacía");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public T peek() throws ExcepcionIsEmpty {
        if (isEmpty()) {
            throw new ExcepcionIsEmpty("La pila está vacía");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
