import java.security.DigestOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        menu();
        try {
            opciones();


            //tenemos leer el fichero que nos lo pone en un arrayList tipo String
            //ArrayList<String> diario = GestionFicheros.leerDiario();
            //ahora tenemos que recorrer el arrayList y pasarlo a un arrayList de tipo NuevaEntrada
            //for(String e : diario) {
            //System.out.println(e);
            //    }

            //Vamos a leer el fichero,, convertirlo en un array de objetos NuevaEntrada y recorres el array

        }catch (Exception e){
            System.out.println("Error vamos a intentarlo de nuevo.");
            menu();
            opciones();

        }
    }




    //Menu
    public static void menu() {
        System.out.println("1. Añadir entrada");
        System.out.println("2. Ver entradas");
        System.out.println("3. Salir");
    }
    //Método para elegir la opción
    public static void opciones() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

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
                menu();
                opciones();
        }
    }

    //Método para añadir una entrada
    public static void nuevaEntrada() {
        Scanner scanner = new Scanner(System.in);
        String fecha = "";
        String nota = "";
        int opcion = 0;

        do {
            System.out.println("Introduce la fecha a mano (1) o la fecha actual (2):");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcion == 1) {
                System.out.println("Introduce la fecha manualmente:");
                fecha = scanner.nextLine();
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
        }while (opcion != 3) ;


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
