package comparacionesBusquedas;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int comparaciones = ordenarSelectionSort(array);
        System.out.println("Número de comparaciones en Selection Sort: " + comparaciones);
    }

    public static int ordenarSelectionSort(int[] array) {
        int comparaciones = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Encontrar el índice del elemento mínimo en la sublista
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento de la sublista
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return comparaciones;
    }
}

