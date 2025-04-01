public class Mergesort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Dividir en dos mitades
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Fusionar las mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        // Fusionar los arreglos ordenados
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
