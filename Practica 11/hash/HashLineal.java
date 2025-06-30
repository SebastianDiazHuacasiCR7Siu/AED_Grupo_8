public class HashLineal {
    private static class Element {
        Integer value;
        boolean isAvailable;

        public Element() {
            this.value = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashLineal(int size) {
        this.size = size;
        table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int x) {
        return x % size;
    }

    public void insert(int x) {
        int index = hash(x);
        int startIndex = index;

        while (!table[index].isAvailable) {
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("Tabla llena. No se pudo insertar " + x);
                return;
            }
        }
        table[index].value = x;
        table[index].isAvailable = false;
    }

    public void printTable() {
        System.out.println("=== Estado final de la tabla hash (tamaño 6) ===");
        for (int i = 0; i < size; i++) {
            if (!table[i].isAvailable && table[i].value != null) {
                System.out.println(i + " -> " + table[i].value);
            } else {
                System.out.println(i + " -> vacío");
            }
        }
    }

    public static void main(String[] args) {
        HashLineal tabla = new HashLineal(6);
        int[] valores = {12, 18, 24, 30};
        for (int v : valores) {
            tabla.insert(v);
        }
        tabla.printTable();
    }
}

