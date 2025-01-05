package busquedas;

public class BusquedaBinaria {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int[] numerosBuscados = {45, 54};
        
        for (int numero : numerosBuscados) {
            int comparaciones = buscarBinaria(array, numero);
            System.out.println("Número " + numero + " - Comparaciones realizadas: " + comparaciones);
        }
    }

    public static int buscarBinaria(int[] array, int objetivo) {
        int comparaciones = 0;
        int inicio = 0, fin = array.length - 1;

        while (inicio <= fin) {
            comparaciones++;
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] == objetivo) {
                System.out.println("Encontrado en posición: " + medio);
                return comparaciones;
            }

            if (array[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        System.out.println("No encontrado.");
        return comparaciones;
    }
}

