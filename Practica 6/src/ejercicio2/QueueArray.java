package ejercicio2;

public class QueueArray<T> implements Queue<T> {
    private T[] data;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("La cola está llena. No se puede insertar.");
            return;
        }
        data[last] = item;
        last = (last + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() throws ExcepcionIsEmpty {
        if (isEmpty()) {
            throw new ExcepcionIsEmpty("La cola está vacía");
        }
        T item = data[first];
        data[first] = null;
        first = (first + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public T front() throws ExcepcionIsEmpty {
        if (isEmpty()) {
            throw new ExcepcionIsEmpty("La cola está vacía");
        }
        return data[first];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
