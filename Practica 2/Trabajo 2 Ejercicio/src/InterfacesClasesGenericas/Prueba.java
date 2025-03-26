package InterfacesClasesGenericas;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuOperaciones menu = new MenuOperaciones();

        System.out.println("Seleccione el tipo de dato:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.print("Opción: ");
        int tipoSeleccionado = scanner.nextInt();

        if (tipoSeleccionado == 1) {
            OperacionesMatBInteger operacionesInt = new OperacionesMatBInteger();
            menu.mostrarMenu(operacionesInt, Integer.class);
        } else if (tipoSeleccionado == 2) {
            OperacionesMatBDouble operacionesDouble = new OperacionesMatBDouble();
            menu.mostrarMenu(operacionesDouble, Double.class);
        } else {
            System.out.println("Selección inválida. Reinicie el programa.");
        }

        scanner.close();
    }
}



