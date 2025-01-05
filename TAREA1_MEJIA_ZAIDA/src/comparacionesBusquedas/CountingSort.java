package comparacionesBusquedas;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int comparaciones = ordenarCountingSort(array);
        System.out.println("Número de comparaciones en Counting Sort: " + comparaciones);
    }

    public static int ordenarCountingSort(int[] array) {
        int comparaciones = 0;

        // Encontrar el rango máximo
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            comparaciones++;
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Crear el array de conteo
        int[] conteo = new int[max + 1];
        for (int num : array) {
            conteo[num]++;
        }

        // Reconstruir el array original
        int index = 0;
        for (int i = 0; i < conteo.length; i++) {
            while (conteo[i] > 0) {
                array[index++] = i;
                conteo[i]--;
            }
        }

        return comparaciones;
    }
}
