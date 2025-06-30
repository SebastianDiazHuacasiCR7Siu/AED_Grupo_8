import java.util.LinkedList;
public class HashEncadenado {
   private static class Registro {
        int clave;
        String nombre;

        public Registro(int clave, String nombre) {
            this.clave = clave;
            this.nombre = nombre;
        }

        public String toString() {
            return "(" + clave + ", " + nombre + ")";
        }
    }

    private LinkedList<Registro>[] tabla;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public HashEncadenado(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hash(int clave) {
        return clave % tamaño;
    }

    public void insertar(int clave, String nombre) {
        int indice = hash(clave);
        tabla[indice].add(new Registro(clave, nombre));
    }

    public String buscar(int clave) {
        int indice = hash(clave);
        for (Registro r : tabla[indice]) {
            if (r.clave == clave) {
                return r.nombre;
            }
        }
        return null;
    }

    public void mostrarTabla() {
        System.out.println("=== Tabla Hash con Encadenamiento ===");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(i + " -> ");
            for (Registro r : tabla[i]) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashEncadenado tabla = new HashEncadenado(5);
        tabla.insertar(10, "Juan");
        tabla.insertar(15, "Ana");
        tabla.insertar(20, "Luis");
        tabla.insertar(25, "Rosa");

        tabla.mostrarTabla();

        int claveBuscada = 20;
        String resultado = tabla.buscar(claveBuscada);

        System.out.println("\nBuscando clave " + claveBuscada + "...");
        if (resultado != null) {
            System.out.println("Nombre asociado a la clave " + claveBuscada + ": " + resultado);
        } else {
            System.out.println("Clave no encontrada.");
        }
    } 
}
