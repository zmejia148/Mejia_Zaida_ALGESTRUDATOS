package busquedas;

public class BusquedaSecuencial {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int[] numerosBuscados = {45, 54};
        
        for (int numero : numerosBuscados) {
            int comparaciones = buscarSecuencial(array, numero);
            System.out.println("Número " + numero + " - Comparaciones realizadas: " + comparaciones);
        }
    }

    public static int buscarSecuencial(int[] array, int objetivo) {
        int comparaciones = 0;
        for (int i = 0; i < array.length; i++) {
            comparaciones++;
            if (array[i] == objetivo) {
                System.out.println("Encontrado en posición: " + i);
                return comparaciones;
            }
        }
        System.out.println("No encontrado.");
        return comparaciones;
    }
}

