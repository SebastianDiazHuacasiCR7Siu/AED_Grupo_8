package InterfacesClasesGenericas;

import java.util.Scanner;

public class EntradaDatos {
    public static <N extends Number> N leerNumero(Scanner scanner, Class<N> tipo) { //Método generico
        if (tipo == Integer.class) {
            return tipo.cast(scanner.nextInt());
        } else if (tipo == Double.class) {
            return tipo.cast(scanner.nextDouble());
        } else {
            throw new IllegalArgumentException("Tipo de dato no soportado.");
        }
    }
}

