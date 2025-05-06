package ejercicio2;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue() throws ExcepcionIsEmpty;
    T front() throws ExcepcionIsEmpty;
    boolean isEmpty();
    boolean isFull();
}
