package InterfacesClasesGenericas;

import java.util.Scanner;

public class MenuOperaciones {
    private Scanner scanner;
    
    public MenuOperaciones() {
        this.scanner = new Scanner(System.in);
    }

    public <N extends Number> void mostrarMenu(Operable<N> operaciones, Class<N> tipo) {
        int opcion;

        do {
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el primer número: ");
                N num1 = EntradaDatos.leerNumero(scanner, tipo);
                System.out.print("Ingrese el segundo número: ");
                N num2 = EntradaDatos.leerNumero(scanner, tipo);

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la Suma: " + operaciones.suma(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado de la Resta: " + operaciones.resta(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado del Producto: " + operaciones.producto(num1, num2));
                        break;
                    case 4:
                        if (num2.doubleValue() != 0) {
                            System.out.println("Resultado de la División: " + operaciones.division(num1, num2));
                        } else {
                            System.out.println("Error: No se puede dividir por cero.");
                        }
                        break;
                    case 5:
                        System.out.println("Resultado de la Potencia: " + operaciones.potencia(num1, num2));
                        break;
                }
            } else if (opcion == 6 || opcion == 7) {
                System.out.print("Ingrese el número: ");
                N num = EntradaDatos.leerNumero(scanner, tipo);

                if (opcion == 6) {
                    System.out.println("Raíz Cuadrada: " + operaciones.raizCuadrada(num));
                } else {
                    System.out.println("Raíz Cúbica: " + operaciones.raizCubica(num));
                }
            } else if (opcion == 8) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 8);
    }
}
