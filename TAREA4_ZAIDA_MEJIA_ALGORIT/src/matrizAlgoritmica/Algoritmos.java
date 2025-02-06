package matrizAlgoritmica;
 
import java.util.Arrays;
import java.util.Random;

public class Algoritmos {
    static final int SIZE = 1000;
    static int[][] matrix = new int[SIZE][SIZE];
    static Random random = new Random();

    public static void main(String[] args) {
        generarMatriz();
        imprimirMatriz();
        
        int x = random.nextInt(2001) - 1000;
        System.out.println("Número a buscar: " + x);
        
        // Búsqueda secuencial
        long start = System.nanoTime();
        boolean foundSec = busquedaSecuencial(x);
        long end = System.nanoTime();
        System.out.println("Búsqueda Secuencial: " + foundSec + " - Tiempo: " + (end - start) + " ns");

        // Búsqueda binaria
        ordenarMatriz();
        start = System.nanoTime();
        boolean foundBin = busquedaBinaria(x);
        end = System.nanoTime();
        System.out.println("Búsqueda Binaria: " + foundBin + " - Tiempo: " + (end - start) + " ns");
    }
    
    static void generarMatriz() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(2001) - 1000;
            }
        }
    }
    
    static void imprimirMatriz() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    static boolean busquedaSecuencial(int x) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == x) {
                    System.out.println("Encontrado en fila " + i + ", columna " + j);
                    return true;
                }
            }
        }
        return false;
    }
    
    static void ordenarMatriz() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.sort(matrix[i]);
        }
    }
    
    static boolean busquedaBinaria(int x) {
        for (int i = 0; i < SIZE; i++) {
            int index = Arrays.binarySearch(matrix[i], x);
            if (index >= 0) {
                System.out.println("Encontrado en fila " + i + ", columna " + index);
                return true;
            }
        }
        return false;
    }
}
