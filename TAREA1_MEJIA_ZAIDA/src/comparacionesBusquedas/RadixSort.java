package comparacionesBusquedas;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int comparaciones = ordenarRadixSort(array);
        System.out.println("Número de comparaciones en Radix Sort: " + comparaciones);
    }

    public static int ordenarRadixSort(int[] array) {
        int comparaciones = 0;

        // Encontrar el número máximo para saber el número de dígitos
        int max = Arrays.stream(array).max().getAsInt();

        // Realizar Counting Sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            comparaciones += countingSortPorDígito(array, exp);
        }

        return comparaciones;
    }

    public static int countingSortPorDígito(int[] array, int exp) {
        int n = array.length;
        int[] salida = new int[n]; // Array temporal de salida
        int[] conteo = new int[10];
        int comparaciones = 0;

        // Contar ocurrencias de los dígitos
        for (int i = 0; i < n; i++) {
            int digito = (array[i] / exp) % 10;
            conteo[digito]++;
        }

        // Cambiar conteo[i] para contener las posiciones reales de los dígitos en salida
        for (int i = 1; i < 10; i++) {
            comparaciones++;
            conteo[i] += conteo[i - 1];
        }

        // Construir el array de salida
        for (int i = n - 1; i >= 0; i--) {
            int digito = (array[i] / exp) % 10;
            salida[conteo[digito] - 1] = array[i];
            conteo[digito]--;
        }

        // Copiar el array de salida al original
        System.arraycopy(salida, 0, array, 0, n);

        return comparaciones;
    }
}

