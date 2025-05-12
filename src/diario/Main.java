package diario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            if(scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                opciones(opcion, scanner); // Llamar al método de opciones
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // Limpiar el input incorrecto
            }
        } while (opcion != 3);
    }


    //Menu
    public static void menu() {
        System.out.println("*************************************");
        System.out.println("1. Añadir entrada");
        System.out.println("2. Ver entradas");
        System.out.println("3. Salir");
        System.out.println("4. Exportar binario a texto");
        System.out.println("5. Leer archivo de texto generado");
        System.out.println("6. Borrar archivo de texto");
        System.out.println("7. Buscar entrada por palabra");
        System.out.println("8. Buscar entrada por fecha");
        System.out.println("*************************************");
    }
    //Método para elegir la opción
    public static void opciones(int opcion, Scanner scanner) {
        System.out.println("*************************************");
        switch (opcion) {
            case 1:
                nuevaEntrada(scanner);
                break;
            case 2:
                verEntradas();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            case 4:
                System.out.println("Crear diario a texto");
                GestionFicherosBin.pasarDeBinarioATexto();
                break;
            case 5:
                System.out.println("Leer diario formato texto");
                GestionFicheros.leerFicheroTexto();
                break;
            case 6:
                System.out.println("Borrar diario formato texto");
                GestionFicheros.borrarArchivoTexto();
                break;
            case 7:
                System.out.println("Buscar entrada por palabra");
                System.out.println("Introduce la palabra a buscar:");
                String palabra = scanner.nextLine();
                GestionFicherosBin.buscarPorPalabra(palabra);
                break;
            case 8:
                System.out.println("Buscar entrada por fecha");
                System.out.println("Introduce la fecha a buscar (dd-MM-yyyy):");
                String fecha = scanner.nextLine();
                GestionFicherosBin.buscarPorFecha(fecha);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        System.out.println("*************************************");
    }

    //Método para añadir una entrada
    public static void nuevaEntrada(Scanner scanner) {
        //scanner.nextInt(); //Limpia el buffer
        String fecha = "";
        String nota = "";

        int tipoEntrada = seleccionarTipoEntrada(scanner);
        NuevaEntrada nuevaEntrada = null;

         switch (tipoEntrada) {
            case 1:
                System.out.println("Diario personal seleccionado");
                nuevaEntrada = crearEntradaDiario(scanner);
                break;
            case 2:
                System.out.println("Reflexión personal seleccionada");
                break;
            case 3:
                System.out.println("Apuntes de clase seleccionados");
                break;
            case 4:
                System.out.println("Frases célebres seleccionadas");
                break;
            default:
                System.out.println("Opción no válida");
        }


        ArrayList<NuevaEntrada> entrada = new ArrayList<>();
//        nuevaEntrada = new NuevaEntrada(fecha, nota);

        entrada.add(nuevaEntrada);

        // Guardar la entrada en el fichero por defecto (diario.dat)
        GestionFicherosBin.escribirFicheroArray(nuevaEntrada, ""); // "" = diario.dat
    }

    //Método para crear una entrada de diario
    public static NuevaEntrada crearEntradaDiario(Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer

        String fecha = GestionFechas.pedirFecha();

        //🔁 Permitir elegir el tipo de entrada (diario, reflexión, apunte, frase, etc.)
        System.out.println("Introduce la nota:");
        String nota = scanner.nextLine();
        return new NuevaEntrada(fecha, nota);
    }



    //Método para ver las entradas
    public static void verEntradas(){
       // ArrayList<NuevaEntrada> entradas = GestionFicheros.leerDiarioGuardarObjetos();
       // for(NuevaEntrada e : entradas) {
        //   System.out.println(e.toString());
        // }

        //Ver entradas del fichero binario
        System.out.println("Entradas del fichero binario:");
        ArrayList<NuevaEntrada> entradasBin = GestionFicherosBin.leerFichero("");
        for(NuevaEntrada e : entradasBin) {
            System.out.println(e.toString());
        }
    }

    public static int seleccionarTipoEntrada(Scanner scanner) {
        System.out.println("Selecciona el tipo de entrada:");
        System.out.println("1. Diario personal");
        System.out.println("2. Reflexión personal");
        System.out.println("3. Apuntes de clase");
        System.out.println("4. Frases célebres");
        System.out.println("0. Cancelar");

        return scanner.nextInt(); // Devuelve la opción elegida

    }



}
