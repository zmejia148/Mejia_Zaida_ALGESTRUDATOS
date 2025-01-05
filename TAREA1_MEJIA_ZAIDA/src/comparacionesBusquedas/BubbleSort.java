package comparacionesBusquedas;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int comparaciones = ordenarBubbleSort(array);
        System.out.println("Número de comparaciones en Bubble Sort: " + comparaciones);
    }

    public static int ordenarBubbleSort(int[] array) {
        int comparaciones = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return comparaciones;
    }
}

