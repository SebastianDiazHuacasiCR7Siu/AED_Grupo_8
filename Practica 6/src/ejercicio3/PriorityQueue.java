package ejercicio3;

public interface PriorityQueue<T> {
    void enqueue(T data, int priority);
    T dequeue() throws ExcepcionIsEmpty;
    boolean isEmpty();
}
