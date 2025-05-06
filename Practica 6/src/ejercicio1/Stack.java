package ejercicio1;

public interface Stack<T> {
    void push(T item);
    T pop() throws ExcepcionIsEmpty;
    T peek() throws ExcepcionIsEmpty;
    boolean isEmpty();
}
