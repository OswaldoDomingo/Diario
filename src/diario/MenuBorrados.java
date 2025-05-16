
package diario;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBorrados {

    public void mostrarMenu(Scanner scanner, ArrayList<NuevaEntrada> entradas) {
        int opcion = -1; // Valor inicial para entrar en el bucle
        do {
            System.out.println("\n¿Qué tipo de entrada quieres borrar?");
            System.out.println("1. Borrado por id");
            System.out.println("2. Frase célebre");
            System.out.println("3. Apunte de libro");
            System.out.println("4. Reflexión personal");
            System.out.println("5. Apunte clase");
            System.out.println("6. Todos los apuntes de una clase concreta");
            System.out.println("7. Borrar todo el diario y los archivos exportados");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            String opcionStr = scanner.nextLine();

            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes introducir un número de opción válido.");
                continue; // Vuelve a mostrar el menú
            }

            GestorEntradas gestorEntradas = new GestorEntradas();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el id de la entrada a borrar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, introduce un número válido:");
                        scanner.next(); // descarta entrada inválida
                    }
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el salto de línea pendiente
                    boolean borrado = gestorEntradas.eliminarEntradaPorId(id, entradas);
                    if (borrado) {
                        System.out.println("Entrada borrada correctamente.");
                        GestionFicherosBin.escribirFichero(entradas, "diario.dat");
                    } else {
                        System.out.println("No se ha encontrado la entrada con el id " + id);
                    }
                    break;
                case 2:
                    borrarEntradaPorTipoYId("frase", scanner, entradas);
                    break;
                case 3:
                    borrarEntradaPorTipoYId("libro", scanner, entradas);
                    break;
                case 4:
                    borrarEntradaPorTipoYId("reflexion", scanner, entradas);
                    break;
                case 5:
                    borrarEntradaPorTipoYId("apunte", scanner, entradas);
                    break;
                case 6:
                    System.out.println("Introduce el nombre de la clase:\nlibro\napunte\nfrase\nreflexion");
                    String tipoEntrada = scanner.next();
                    scanner.nextLine(); // Limpiar el salto de línea pendiente
                    borrarEntradaPorTipo(tipoEntrada, entradas);
                    break;
                case 7:
                    borrarTodoElDiario(entradas, scanner); // Llama al método que has creado
                    break;
                case 0:
                    System.out.println("Saliendo del menú de borrados.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);
    }

    /**
     * Borra todo el contenido del diario y elimina también los archivos txt y csv.
     * @param entradas ArrayList con todas las entradas del diario
     * @param scanner Objeto Scanner para leer la confirmación del usuario
     */
    // Método para borrar todo el diario
    private void borrarTodoElDiario(ArrayList<NuevaEntrada> entradas, Scanner scanner) {
        System.out.println("¿Estás seguro de que quieres borrar todo el diario y los archivos exportados? (s/n)");

        String confirmacion = scanner.nextLine();

        if (!confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Operación cancelada.");
            return;
        }

        // Vaciamos la lista de entradas
        entradas.clear();
        System.out.println("Se han borrado todas las entradas del diario.");

        // Reescribimos el fichero binario vacío
        GestionFicherosBin.escribirFichero(entradas, "diario.dat");
        System.out.println("Fichero binario reescrito correctamente.");

        // Borramos el archivo TXT si existe
        java.io.File archivoTxt = new java.io.File("diario.txt");
        if (archivoTxt.exists()) {
            if (archivoTxt.delete()) {
                System.out.println("Archivo diario.txt borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el archivo diario.txt.");
            }
        }

        // Borramos el archivo CSV si existe
        java.io.File archivoCsv = new java.io.File("diario.csv");
        if (archivoCsv.exists()) {
            if (archivoCsv.delete()) {
                System.out.println("Archivo diario.csv borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el archivo diario.csv.");
            }
        }


// Ponemos el contador de entradas a 0 (reinicio del id)
        java.io.File archivoId = new java.io.File("id.txt");

// Comprobamos si el archivo existe
        if (archivoId.exists()) {
            try (java.io.FileWriter writer = new java.io.FileWriter(archivoId)) {
                writer.write("0"); // Escribimos el valor 0
                System.out.println("Contador de entradas reiniciado a 0.");
            } catch (java.io.IOException e) {
                System.out.println("Error al reiniciar el contador de entradas: " + e.getMessage());
            }
        } else {
            // Si no existe, lo creamos y lo ponemos a 0 igualmente
            try (java.io.FileWriter writer = new java.io.FileWriter(archivoId)) {
                writer.write("0");
                System.out.println("El archivo id.txt no existía, se ha creado y reiniciado a 0.");
            } catch (java.io.IOException e) {
                System.out.println("Error al crear y reiniciar el contador de entradas: " + e.getMessage());
            }
        }

    }


    /**
     * Borra todas las entradas de un tipo concreto del ArrayList y actualiza el fichero binario.
     * @param tipoEntrada Tipo de entrada a borrar (por ejemplo, "libro", "frase", etc.)
     * @param entradas    Lista de entradas del diario
     */

    private void borrarEntradaPorTipo(String tipoEntrada, ArrayList<NuevaEntrada> entradas){
// Lista de tipos válidos (puedes ponerlos como constantes o mejor aún, como enum)
        String[] tiposValidos = {"libro", "apunte", "frase", "reflexion"};

// Variable para saber si el tipo introducido es válido
        boolean tipoValido = false;

// Recorremos la lista de tipos válidos para ver si coincide con el introducido
        for (String tipo : tiposValidos) {
            if (tipoEntrada.equalsIgnoreCase(tipo)) {
                tipoValido = true; // Si es válido, lo marcamos como true
                break;             // Y salimos del bucle
            }
        }

// Si el tipo NO es válido, avisamos al usuario y no seguimos
        if (!tipoValido) {
            System.out.println("Tipo de entrada NO válido. Debe ser uno de: libro, apunte, frase o reflexion.");
            return;
        }
       //Contador de entradas
       int contadorEntradas = 0;

       //Recorrer el arraylist de entradas
         for(NuevaEntrada entrada : entradas){
              //Si la entrada es del tipo que queremos borrar
              if(entrada.getTipoEntrada().equalsIgnoreCase(tipoEntrada)){
                System.out.println(entrada.toString());
                contadorEntradas++;
              }
         }
            if(contadorEntradas == 0){
                System.out.println("No se han encontrado entradas de tipo " + tipoEntrada);
                return;
            }else{
                System.out.println("Se han encontrado " + contadorEntradas + " entradas de tipo " + tipoEntrada);
            }
            // Borrar todas las entradas de ese tipo
            for (int i = entradas.size() - 1; i >= 0; i--) {
                if (entradas.get(i).getTipoEntrada().equalsIgnoreCase(tipoEntrada)) {
                    entradas.remove(i);
                }
            }
            System.out.println("Se han borrado todas las entradas de tipo " + tipoEntrada);
            // Reescribir el fichero
            GestionFicherosBin.escribirFichero(entradas, "diario.dat");
            System.out.println("Fichero reescrito correctamente.");

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
