import ejercicio3.*;

public class Test3 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueueLinked<>(4);

        pq.enqueue("Alta prioridad A", 0);
        pq.enqueue("Media prioridad B", 2);
        pq.enqueue("Alta prioridad C", 0);
        pq.enqueue("Baja prioridad D", 3);
        pq.enqueue("Media prioridad E", 2);

        try {
            while (!pq.isEmpty()) {
                System.out.println("Desencolado: " + pq.dequeue());
            }
        } catch (ExcepcionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
