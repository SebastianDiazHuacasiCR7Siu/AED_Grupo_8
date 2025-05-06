import java.util.List;

public class UtilidadesLista {
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        return lista.contains(valor);
    }

    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new java.util.ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }
}
