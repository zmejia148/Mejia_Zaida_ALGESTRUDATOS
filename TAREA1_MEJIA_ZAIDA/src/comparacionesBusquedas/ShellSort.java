package comparacionesBusquedas;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int comparaciones = ordenarShellSort(array);
        System.out.println("Número de comparaciones en Shell Sort: " + comparaciones);
    }

    public static int ordenarShellSort(int[] array) {
        int comparaciones = 0;
        int n = array.length;

        // Inicializamos el gap y lo reducimos progresivamente
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                // Realizamos inserciones directas con el gap
                for (j = i; j >= gap; j -= gap) {
                    comparaciones++;
                    if (array[j - gap] > temp) {
                        array[j] = array[j - gap];
                    } else {
                        break;
                    }
                }
                array[j] = temp;
            }
        }
        return comparaciones;
    }
}
