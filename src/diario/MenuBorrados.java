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
        System.out.println("5. Apunte clase");
        System.out.println("0. Salir");

        System.out.println("Selecciona una opción:");
        int opcion = scanner.nextInt();
        GestorEntradas gestorEntradas = new GestorEntradas();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el id de la entrada a borrar:");
                int id = scanner.nextInt();
                //Llamamos al método eliminarEntradaPorId
                boolean borrado = gestorEntradas.eliminarEntradaPorId(id, entradas);
                if (borrado) {
                    System.out.println("Entrada borrada correctamente.");
                    //Reescribir el fichero
                    GestionFicherosBin.escribirFichero(entradas, "diario.dat");
                } else {
                    System.out.println("No se ha encontrado la entrada con el id " + id);
                }
                break;
            case 2:
                // Implementar borrado por frase célebre
                borrarEntradaPorTipoYId("frase", scanner, entradas);
                break;

            case 3:
                // Implementar borrado por apunte de libro
                borrarEntradaPorTipoYId("libro", scanner, entradas);
                break;
            case 4:
                // Implementar borrado por reflexión personal
                borrarEntradaPorTipoYId("reflexion", scanner, entradas);
                break;
            case 5:
                // Implementar borrado por apunte clase
                borrarEntradaPorTipoYId("apunte", scanner, entradas);
                break;
            case 0:
                System.out.println("Saliendo del menú de borrados.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }


    }
    private void borrarEntradaPorTipoYId(String tipoEntrada, Scanner scanner, ArrayList<NuevaEntrada> entradas) {
        // Contador de entradas
        int contadorEntradas = 0;

        System.out.println("Entradas encontradas:");
        for (NuevaEntrada entrada : entradas) {
            if (entrada.getTipoEntrada().equalsIgnoreCase(tipoEntrada)) {
                System.out.println(entrada.toString());
                contadorEntradas++;
            }
        }

        if (contadorEntradas == 0) {
            System.out.println("No se han encontrado entradas de tipo " + tipoEntrada);
            return;
        } else {
            System.out.println("Se han encontrado " + contadorEntradas + " entradas de tipo " + tipoEntrada);
        }

        // Pedir al usuario el ID a borrar
        System.out.println("\nIntroduce el id de la entrada a borrar:");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido:");
            scanner.next(); // descarta entrada inválida
        }
        int id = scanner.nextInt();

        // Buscar dentro de entradas si Id pertenece a una entrada del tipo especificado
        boolean encontrada = false;
        for (NuevaEntrada entrada : entradas) {
            if (entrada.getId() == id && entrada.getTipoEntrada().equalsIgnoreCase(tipoEntrada)) {
                entradas.remove(entrada);
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println(tipoEntrada + " borrada correctamente.");
            GestionFicherosBin.escribirFichero(entradas, "diario.dat");
        } else {
            System.out.println("No se ha encontrado ninguna entrada de tipo " + tipoEntrada + " con ese ID.");
        }
    }



}
