
public class TestHash {
    public static void main(String [] args){
        HashC tabla = new HashC(10);

        tabla.insert(new Register(34, "Ana"));
        tabla.insert(new Register(3, "Luis"));
        tabla.insert(new Register(7, "Pedro"));
        tabla.insert(new Register(30, "Marta"));
        tabla.insert(new Register(11, "Juan"));
        tabla.insert(new Register(8,  "Lucía"));
        tabla.insert(new Register(34,  "Carlos")); // clave repetida
        tabla.insert(new Register(23, "Rosa"));
        tabla.insert(new Register(41, "Elena"));
        tabla.insert(new Register(16, "Mario"));
        tabla.insert(new Register(34, "Andrés")); // clave repetida

          // Mostrar estado de la tabla
        System.out.println("=== Estado inicial de la tabla ===");
        tabla.printTable();

        // Eliminar la clave 30
        System.out.println("\nEliminando clave 30...");
        tabla.delete(30);

        // Mostrar estado de la tabla después de eliminar
        System.out.println("\n=== Estado de la tabla después de eliminar 30 ===");
        tabla.printTable();

        // Buscar la clave 23
        System.out.println("\nBuscando clave 23...");
        Register resultado = tabla.search(23);
        if (resultado != null) {
            System.out.println("Clave 23 encontrada: " + resultado);
        } else {
            System.out.println("Clave 23 no encontrada.");
        }
    }
}
