package diario;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBorrados {

    public void mostrarMenu(Scanner scanner, ArrayList<NuevaEntrada> entradas) {
        System.out.println("¿Qué tipo de entrada quieres borrar?");
        System.out.println("1. Borrado por id");
        System.out.println("2. Frase célebre");
        System.out.println("3. Apunte de libro");
        System.out.println("4. Reflexión personal");
        System.out.println("0. Salir");

        System.out.println("Selecciona una opción:");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el id de la entrada a borrar:");
                int id = scanner.nextInt();
                GestorEntradas gestorEntradas = new GestorEntradas();
                //Llamamos al método eliminarEntradaPorId
                boolean borrado = gestorEntradas.eliminarEntradaPorId(id, entradas);
                if (borrado) {
                    System.out.println("Entrada borrada correctamente.");
                    //Reescribir el fichero
                    GestionFicherosBin.escribirFichero(entradas, "");
                } else {
                    System.out.println("No se ha encontrado la entrada con el id " + id);
                }
                break;
            case 2:
                // Implementar borrado por frase célebre
                break;
            case 3:
                // Implementar borrado por apunte de libro
                break;
            case 4:
                // Implementar borrado por reflexión personal
                break;
            case 0:
                System.out.println("Saliendo del menú de borrados.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }


    }


}
