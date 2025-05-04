package diario;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            opciones(opcion); // Le pasamos la opción seleccionada
        } while (opcion != 3);
    }




    //Menu
    public static void menu() {
        System.out.println("1. Añadir entrada");
        System.out.println("2. Ver entradas");
        System.out.println("3. Salir");
    }
    //Método para elegir la opción
    public static void opciones(int opcion) {

        switch (opcion) {
            case 1:
                nuevaEntrada();
                break;
            case 2:
                verEntradas();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    //Método para añadir una entrada
    public static void nuevaEntrada() {
        Scanner scanner = new Scanner(System.in);
        String fecha;
        String nota;
        int opcion;

        System.out.println("Introduce la fecha a mano (1) o la fecha actual (2):");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        boolean correcto = false;

        if (opcion == 1) {
            do {
                System.out.println("Introduce la fecha manualmente (dd-MM-yyyy):");
                fecha = scanner.nextLine();
                if (GestionFechas.comprobarFormatoFecha(fecha)) {
                    correcto = true;
                } else {
                    System.out.println("Formato de fecha incorrecto. Por favor, introduce la fecha en el formato dd-MM-yyyy.");
                }
            } while (!correcto);
        } else if (opcion == 2) {
            fecha = GestionFechas.obtenerFecha();
        } else {
            System.out.println("Opción no válida");
            return;
        }

        System.out.println("Introduce la nota:");
        nota = scanner.nextLine();

        ArrayList<NuevaEntrada> entrada = new ArrayList<>();
        NuevaEntrada nuevaEntrada = new NuevaEntrada(fecha, nota);

        entrada.add(nuevaEntrada);

        GestionFicheros.escribirFichero(nuevaEntrada);
        GestionFicherosBin.escribirFicheroArray(nuevaEntrada);
    }


    //Método para ver las entradas
    public static void verEntradas(){
        ArrayList<NuevaEntrada> entradas = GestionFicheros.leerDiarioGuardarObjetos();
        for(NuevaEntrada e : entradas) {
            System.out.println(e.toString());
        }
        //Ver entradas del fichero binario
        System.out.println("Entradas del fichero binario:");
        ArrayList<NuevaEntrada> entradasBin = GestionFicherosBin.leerFichero();
        for(NuevaEntrada e : entradasBin) {
            System.out.println(e.toString());
        }
    }



}
