import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        
        // Llamar al algoritmo MergeSort para ordenar el arreglo
        Mergesort.mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }
}
