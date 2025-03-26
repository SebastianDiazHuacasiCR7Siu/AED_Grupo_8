import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<T>();
    private int tope;

    public Bolsa(int tope) {
        super();
        this.tope = tope;
    }

    public void add(T objeto) {
        if (lista.size() >= tope) {
            throw new RuntimeException("No caben más elementos. Límite alcanzado.");
        } else {
            lista.add(objeto);
        }
    }

   
    public Iterator<T> iterator() {
        return lista.iterator();
    }

   
    public int getCantidad() {
        return lista.size();
    }

   
    public boolean estaLlena() {
        return lista.size() >= tope;
    }

   
    public int getTope() {
        return tope;
    }
}


