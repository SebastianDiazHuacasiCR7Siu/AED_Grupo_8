import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T> {
    private Node<T> head;           //cabeza de la lista enlazada

    //constructor que inicializa la lista vacia 
    public GestorDeTareas() {
        this.head = null;
    } 

    //agrega tarea al final de la lista
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        if (head.getData().equals(tarea)) {
            head = head.getNext();
            return true;
        }

        Node<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getData().equals(tarea)) {
                actual.setNext(actual.getNext().getNext());
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.getData().equals(tarea)) {
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }

    public int contarTareas() {
        int count = 0;
        Node<T> actual = head;
        while (actual != null) {
            count++;
            actual = actual.getNext();
        }
        return count;
    }

    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;

        if (!(head.getData() instanceof Tarea)) {
            throw new UnsupportedOperationException("Este método solo funciona con objetos Tarea.");
        }

        Node<T> actual = head;
        Tarea mayor = (Tarea) actual.getData();

        while (actual != null) {
            Tarea tareaActual = (Tarea) actual.getData();
            if (tareaActual.getPrioridad() > mayor.getPrioridad()) {
                mayor = tareaActual;
            }
            actual = actual.getNext();
        }
        return (T) mayor;
    }

    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;
        Node<T> siguiente;

        while (actual != null) {
            siguiente = actual.getNext();
            actual.setNext(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    public List<T> transferirTarea(T tarea) {
        List<T> tareasCompletadas = new ArrayList<>();
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
        }
        return tareasCompletadas;
    }
}