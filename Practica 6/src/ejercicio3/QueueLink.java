package ejercicio3;

public class QueueLink<T> {
    private Node<T> first;
    private Node<T> last;

    public QueueLink() {
        first = last = null;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public T dequeue() throws ExcepcionIsEmpty {
        if (isEmpty()) {
            throw new ExcepcionIsEmpty("Cola vacía");
        }
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
