package encriptacion;

import java.util.Scanner;

public class CifradoCesar {

    // Método para encriptar un texto
    public static String encriptar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        desplazamiento = desplazamiento % 26;

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                caracter = (char) ((caracter - base + desplazamiento + 26) % 26 + base);
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    // Método para desencriptar un texto
    public static String desencriptar(String texto, int desplazamiento) {
        return encriptar(texto, -desplazamiento);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el texto a cifrar:");
        String textoOriginal = scanner.nextLine();

        System.out.println("Ingrese el desplazamiento:");
        int desplazamiento = scanner.nextInt();
        scanner.nextLine(); 
        
        String textoEncriptado = encriptar(textoOriginal, desplazamiento);
        String textoDesencriptado = desencriptar(textoEncriptado, desplazamiento);
        
        System.out.println("¿Cómo desea ver el texto? (1: Encriptado, 2: Desencriptado, 3: Ambos)");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Texto Encriptado: " + textoEncriptado);
                break;
            case 2:
                System.out.println("Texto Desencriptado: " + textoDesencriptado);
                break;
            case 3:
                System.out.println("Texto Encriptado: " + textoEncriptado);
                System.out.println("Texto Desencriptado: " + textoDesencriptado);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
