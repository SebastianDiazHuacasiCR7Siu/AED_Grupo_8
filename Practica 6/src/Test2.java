import ejercicio2.*;

public class Test2 {
    public static void main(String[] args) {
        Queue<Integer> colaEnteros = new QueueArray<>(3);
        Queue<String> colaStrings = new QueueArray<>(2);

        try {
            // Cola de enteros
            colaEnteros.enqueue(1);
            colaEnteros.enqueue(2);
            colaEnteros.enqueue(3);
            colaEnteros.enqueue(4); // No debe insertarse

            System.out.println("Frente de colaEnteros: " + colaEnteros.front());
            System.out.println("Eliminar: " + colaEnteros.dequeue());
            System.out.println("Frente actualizado: " + colaEnteros.front());

            // Cola de Strings
            colaStrings.enqueue("Hola");
            colaStrings.enqueue("Mundo");
            colaStrings.enqueue("Cruel"); // No debe insertarse

            System.out.println("Frente de colaStrings: " + colaStrings.front());
            System.out.println("Eliminar: " + colaStrings.dequeue());
            System.out.println("Frente actualizado: " + colaStrings.front());

        } catch (ExcepcionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}
