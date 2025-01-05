package comparacionesBusquedas;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int[] comparaciones = {0}; // Usamos un arreglo para permitir la modificación dentro de métodos recursivos
        ordenarMergeSort(array, 0, array.length - 1, comparaciones);
        System.out.println("Número de comparaciones en Merge Sort: " + comparaciones[0]);
    }

    public static void ordenarMergeSort(int[] array, int inicio, int fin, int[] comparaciones) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            // Dividir el array en dos mitades
            ordenarMergeSort(array, inicio, medio, comparaciones);
            ordenarMergeSort(array, medio + 1, fin, comparaciones);

            // Combinar las dos mitades
            merge(array, inicio, medio, fin, comparaciones);
        }
    }

    public static void merge(int[] array, int inicio, int medio, int fin, int[] comparaciones) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        // Crear arrays temporales
        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        // Copiar datos a los arrays temporales
        System.arraycopy(array, inicio, izquierda, 0, n1);
        System.arraycopy(array, medio + 1, derecha, 0, n2);

        // Combinar los arrays temporales
        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            comparaciones[0]++;
            if (izquierda[i] <= derecha[j]) {
                array[k++] = izquierda[i++];
            } else {
                array[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes
        while (i < n1) {
            array[k++] = izquierda[i++];
        }
        while (j < n2) {
            array[k++] = derecha[j++];
        }
    }
}
