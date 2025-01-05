package busquedas;

public class BusquedaInterpolacion {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int[] numerosBuscados = {45, 54};

        for (int numero : numerosBuscados) {
            int comparaciones = buscarInterpolacion(array, numero);
            System.out.println("Número " + numero + " - Comparaciones realizadas: " + comparaciones);
        }
    }

    public static int buscarInterpolacion(int[] array, int objetivo) {
        int comparaciones = 0;
        int inicio = 0, fin = array.length - 1;

        while (inicio <= fin && objetivo >= array[inicio] && objetivo <= array[fin]) {
            comparaciones++;

            // Calcular la posición estimada
            int posicion = inicio + ((objetivo - array[inicio]) * (fin - inicio)) / (array[fin] - array[inicio]);

            if (array[posicion] == objetivo) {
                System.out.println("Encontrado en posición: " + posicion);
                return comparaciones;
            }

            if (array[posicion] < objetivo) {
                inicio = posicion + 1;
            } else {
                fin = posicion - 1;
            }
        }
        System.out.println("No encontrado.");
        return comparaciones;
    }
}

