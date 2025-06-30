public class HashConEliminacion {
    private static class Elemento {
        Integer valor;
        boolean disponible;

        public Elemento() {
            this.valor = null;
            this.disponible = true;
        }
    }

    private Elemento[] tabla;
    private int tamaño;

    public HashConEliminacion(int tamaño) {
        this.tamaño = tamaño;
        tabla = new Elemento[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new Elemento();
        }
    }

    private int hash(int x) {
        return x % tamaño;
    }

    public void insertar(int x) {
        int indice = hash(x);
        int inicio = indice;

        while (!tabla[indice].disponible) {
            indice = (indice + 1) % tamaño;
            if (indice == inicio) {
                System.out.println("Tabla llena. No se pudo insertar " + x);
                return;
            }
        }

        tabla[indice].valor = x;
        tabla[indice].disponible = false;
    }

    public void eliminar(int x) {
        int indice = hash(x);
        int inicio = indice;

        while (tabla[indice].valor != null || !tabla[indice].disponible) {
            if (!tabla[indice].disponible && tabla[indice].valor.equals(x)) {
                tabla[indice].valor = null;
                tabla[indice].disponible = true;
                System.out.println("Clave eliminada: " + x);
                return;
            }
            indice = (indice + 1) % tamaño;
            if (indice == inicio) break;
        }

        System.out.println("Clave no encontrada: " + x);
    }

    public boolean buscar(int x) {
        int indice = hash(x);
        int inicio = indice;

        while (tabla[indice].valor != null || !tabla[indice].disponible) {
            if (!tabla[indice].disponible && tabla[indice].valor.equals(x)) {
                return true;
            }
            indice = (indice + 1) % tamaño;
            if (indice == inicio) break;
        }

        return false;
    }

    public void mostrarTabla() {
        System.out.println("=== Estado de la tabla ===");
        for (int i = 0; i < tamaño; i++) {
            if (!tabla[i].disponible && tabla[i].valor != null) {
                System.out.println(i + " -> " + tabla[i].valor);
            } else {
                System.out.println(i + " -> vacío");
            }
        }
    }

    public static void main(String[] args) {
        HashConEliminacion tabla = new HashConEliminacion(7);
        int[] claves = {5, 12, 19};

        for (int x : claves) {
            tabla.insertar(x);
        }

        tabla.mostrarTabla();

        // Eliminar clave 12
        System.out.println("\nEliminando clave 12...");
        tabla.eliminar(12);

        tabla.mostrarTabla();

        // Buscar clave 19 después de eliminar 12
        System.out.println("\nBuscando clave 19...");
        if (tabla.buscar(19)) {
            System.out.println("Clave 19 encontrada.");
        } else {
            System.out.println("Clave 19 NO encontrada.");
        }
    }
}
