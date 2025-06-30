public class HashSimple {
    private Integer[] tabla;
    private int tamaño;

    public HashSimple(int tamaño) {
        this.tamaño = tamaño;
        tabla = new Integer[tamaño];
    }

    private int hash(int x) {
        return x % tamaño;
    }

    public void insertar(int x) {
        int indice = hash(x);
        if (tabla[indice] == null) {
            tabla[indice] = x;
        } else {
            System.out.println("Colisión al insertar " + x + " en la posición " + indice + ". Valor no insertado.");
        }
    }

    public void mostrarTabla() {
        System.out.println("=== Estado final de la tabla hash ===");
        for (int i = 0; i < tamaño; i++) {
            if (tabla[i] != null) {
                System.out.println(i + " -> " + tabla[i]);
            } else {
                System.out.println(i + " -> vacío");
            }
        }
    }

    public static void main(String[] args) {
        HashSimple tabla = new HashSimple(7);
        int[] valores = {3, 10, 17, 24};

        for (int x : valores) {
            tabla.insertar(x);
        }

        tabla.mostrarTabla();
    }
}


