import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        //se añaden 3 tareas con diferentes prioridades cada una
        gestor.agregarTarea(new Tarea("Terminar informe", 5));
        gestor.agregarTarea(new Tarea("Preparar presentación", 7));
        gestor.agregarTarea(new Tarea("Revisar emails", 3));

        //se muestran las tareas que actualmente estan en la lista
        System.out.println("Tareas actuales:"); 
        gestor.imprimirTareas();

        //se elimina la tarea "Revisar emails" de la lista
        gestor.eliminarTarea(new Tarea("Revisar emails", 3));
        System.out.println("\nDespués de eliminar una tarea:");
        gestor.imprimirTareas();

        //se comprueba si la tarea "Preparar presentacion" esta en la lista
        System.out.println("\n¿Existe la tarea 'Preparar presentación'?: " + gestor.contieneTarea(new Tarea("Preparar presentación", 7)));

        //invierte la lista de tareas
        gestor.invertirTareas();
        System.out.println("\nLista invertida:");
        gestor.imprimirTareas();

        // Se transfiere la tarea "Terminar informe" a la lista de tareas completadas.
        List<Tarea> tareasCompletadas = new ArrayList<>();
        tareasCompletadas.addAll(gestor.transferirTarea(new Tarea("Terminar informe", 5)));

         // 8. Mostrar tareas completadas
        System.out.println("\nTareas Completadas:");
        for (Tarea t : tareasCompletadas) {
            System.out.println(t);
        }

        // se muestran las tareas restantes
        System.out.println("\nTareas restantes:");
        gestor.imprimirTareas();

        //se muestra la tarea con la mayor prioridad de las que quedanq
        System.out.println("\nTarea de mayor prioridad:");
        System.out.println(gestor.obtenerTareaMasPrioritaria());
    }
}
