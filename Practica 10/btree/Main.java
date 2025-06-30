package btree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>(4); // Árbol B de orden 4

        int[] nuevosValores = {
            100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93,94
        };

        for (int val : nuevosValores) {
            tree.insert(val);
        }

        System.out.println("Nueva Tabla del Árbol B ");
        tree.printTreeTable();
    }
}


