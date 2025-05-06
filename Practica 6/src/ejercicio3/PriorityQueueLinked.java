package ejercicio3;

public class PriorityQueueLinked<T> implements PriorityQueue<T> {
    private QueueLink<T>[] colas;
    private int nPrioridades;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int nPrioridades) {
        this.nPrioridades = nPrioridades;
        colas = new QueueLink[nPrioridades];
        for (int i = 0; i < nPrioridades; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(T data, int priority) {
        if (priority < 0 || priority >= nPrioridades) {
            throw new IllegalArgumentException("Prioridad inválida");
        }
        colas[priority].enqueue(data);
    }

    @Override
    public T dequeue() throws ExcepcionIsEmpty {
        for (int i = 0; i < nPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExcepcionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public boolean isEmpty() {
        for (QueueLink<T> cola : colas) {
            if (!cola.isEmpty()) return false;
        }
        return true;
    }
}
