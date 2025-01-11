package gestionTarea;

import java.util.*;

public class GestionTareas {
    private Stack<String> tareasPendientes;
    private Queue<String> tareasCompletadas;

    public GestionTareas() {
        tareasPendientes = new Stack<>();
        tareasCompletadas = new LinkedList<>();
    }

    public void agregarTarea(String tarea) {
        tareasPendientes.push(tarea);
        System.out.println("\n Tarea agregada: " + tarea);
    }

    public void marcarTareaCompletada(String tarea) {
        if (tareasPendientes.contains(tarea)) {
            tareasPendientes.remove(tarea);
            tareasCompletadas.add(tarea);
            System.out.println("\n Tarea completada: " + tarea);
        } else {
            System.out.println("=== La tarea no se encontró en las pendientes.===");
        }
    }

    public void eliminarTarea(String tarea) {
        if (tareasPendientes.isEmpty()) {
            System.out.println("=== No hay tareas pendientes para eliminar.===");
        } else if (tareasPendientes.remove(tarea)) {
            System.out.println("Tarea eliminada: " + tarea);
        } else {
            System.out.println("=== La tarea no se encontró en las pendientes.===");
        }
    }

    public void verTareasPendientes() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("\n === No hay tareas pendientes. ===");
        } else {
            System.out.println("\n Tareas pendientes:");
            for (String tarea : tareasPendientes) {
                System.out.println("- " + tarea);
            }
        }
    }

    public void verProximaTarea() {
        if (!tareasPendientes.isEmpty()) {
            System.out.println("\n Próxima tarea: " + tareasPendientes.peek());
        } else {
            System.out.println("=== No hay tareas pendientes. ===");
        }
    }

    public static void main(String[] args) {
        GestionTareas gestion = new GestionTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Ver tareas pendientes");
            System.out.println("5. Ver próxima tarea");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
            case 1:
                System.out.print("\n Ingrese la tarea: ");
                String tarea = scanner.nextLine();
                gestion.agregarTarea(tarea);
                break;
            case 2:
                System.out.println("\n Tareas pendientes:");
                gestion.verTareasPendientes();
                System.out.print("\n Ingrese la tarea a marcar como completada: ");
                String tareaCompletada = scanner.nextLine();
                gestion.marcarTareaCompletada(tareaCompletada);
                break;
            case 3:
                if (gestion.tareasPendientes.isEmpty()) {
                    System.out.println("=== No hay tareas pendientes para eliminar.===");
                } else {
                    System.out.print("\nIngrese la tarea a eliminar: ");
                    String tareaEliminar = scanner.nextLine();
                    gestion.eliminarTarea(tareaEliminar);
                }
                break;
            case 4:
                gestion.verTareasPendientes();
                break;
            case 5:
                gestion.verProximaTarea();
                break;
            case 6:
                System.out.println("\n\n FINALIZANDO SISTEMA...");
                break;
            default:
                System.out.println("*** Opción inválida, intente nuevamente.***");
         }
     } while (opcion != 6);

     scanner.close();
    }
}
