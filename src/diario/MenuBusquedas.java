package diario;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuBusquedas {

    public void menuBusquedas(Scanner scanner, ArrayList<NuevaEntrada> entradas){
        int opcion = -1;

        do{
            System.out.println("\nQué tipo de búsqueda quieres realizar?");
            System.out.println("0. Salir");
            System.out.println("1. Buscar por fecha concreta");
            System.out.println("2. Buscar por rango de fechas");

            String opcionString = scanner.nextLine();
            try {
                opcion = Integer.parseInt(opcionString);
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes introducir un número de opción válido.");
                continue;//Vuelve a mostrar el menu
            }
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del menú de búsqueda.");
                    break;
                case 1:
                    System.out.println("Introduce la fecha a buscar (dd-MM-yyyy):");
                    String fecha = scanner.nextLine();
                    GestionFechas.buscarMismaFecha(fecha, entradas);
                    break;
                case 2:
                    System.out.println("Introduce la fecha de inicio (dd-MM-yyyy):");
                    String fechaInicio = scanner.nextLine();
                    System.out.println("Introduce la fecha de fin (dd-MM-yyyy):");
                    String fechaFin = scanner.nextLine();
                    //Llamar al método de búsqueda por rango de fechas
                    GestionFechas.buscarRangoFechas(fechaInicio, fechaFin, entradas);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número válido.");
            }
        }while (opcion !=0);
    }

}
