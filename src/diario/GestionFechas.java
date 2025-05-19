package diario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionFechas {

    //Fecha
    public static String obtenerFecha() {
        //Obtenemos la fecha actual
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return fechaActual;
    }

    //Método que comprueba si una fecha tiene el formato correcto
    public static boolean comprobarFormatoFecha(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Establece el modo estricto para la validación
        try {
            sdf.parse(fecha); // Intenta analizar la fecha
            return true; // Si no lanza excepción, el formato es correcto
        } catch (Exception e) {
            return false; // Si lanza excepción, el formato es incorrecto
        }
    }

    //Método para convertir yna fecha String a LocalDate
    public static LocalDate convertirStringALocalDate(String fecha) {
        // Comprobamos si el string es null o está vacío
        if (fecha == null || fecha.trim().isEmpty()) {
            System.out.println("Fecha nula o vacía");
            return null;
        }

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral('-')
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral('-')
                .appendPattern("yyyy")
                .toFormatter();


        try {
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido: " + fecha);
            return null;
        }
    }

    public static LocalDate convertirStringALocalDateBuscarPorFechas(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            System.out.println("Fecha nula o vacía");
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("[d-M-yyyy][dd-MM-yyyy]")
                .toFormatter();
        try {
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido: " + fecha);
            return null;
        }
    }


    public static String pedirFecha() {
        String fecha = "";
        int opcion;
        LocalDate fechaLocalDate;
        Scanner scanner = new Scanner(System.in);
        boolean opcionCorrecta = false;

        do {
            System.out.println("Introduce la fecha a mano (1) o la fecha actual (2):");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcion == 1) {
                boolean correcto = false;
                do {
                    System.out.println("Introduce la fecha manualmente (dd-MM-yyyy):");
                    fecha = scanner.nextLine();
                    if (GestionFechas.comprobarFormatoFecha(fecha)) {
                        correcto = true;
                        opcionCorrecta = true;
                    } else {
                        System.out.println("Formato de fecha incorrecto. Por favor, usa dd-MM-yyyy.");
                    }
                } while (!correcto);
            } else if (opcion == 2) {
                fecha = GestionFechas.obtenerFecha();
                opcionCorrecta = true;
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (!opcionCorrecta);

        return fecha;
    }

    public static void buscarMismaFecha(String fecha, ArrayList<NuevaEntrada> entradas) {
        if (!comprobarFormatoFecha(fecha)) {
            System.out.println("Formato de fecha incorrecto. Por favor, usa dd-MM-yyyy.");
            return;
        }
        boolean encontrado = false;
        for (NuevaEntrada entrada : entradas) {
            if (entrada.getFecha().equals(fecha)) {
                System.out.println(entrada);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay entradas para la fecha " + fecha);
        }
    }

    public static void buscarRangoFechas(String fechaInicio, String fechaFin, ArrayList<NuevaEntrada> entradas) {
        // Comprobamos si las fechas tienen el formato correcto
        if (!comprobarFormatoFecha(fechaInicio) || !comprobarFormatoFecha(fechaFin)) {
            System.out.println("Formato de fecha incorrecto. Por favor, usa dd-MM-yyyy.");
            return;
        }
        // Convertimos las fechas a LocalDate
        LocalDate fechaInicioLocalDate = convertirStringALocalDateBuscarPorFechas(fechaInicio);
        LocalDate fechaFinLocalDate = convertirStringALocalDateBuscarPorFechas(fechaFin);

        boolean encontrado = false;

        // Comprobamos si la fecha de inicio es anterior a la fecha de fin
        if(fechaFinLocalDate.isBefore(fechaInicioLocalDate)){
            System.out.println("La fecha de fin no puede ser anterior a la fecha de inicio.");
            return;
        }

        for (NuevaEntrada entrada : entradas) {
            LocalDate fechaEntrada = convertirStringALocalDate(entrada.getFecha());

            if (fechaEntrada == null) continue;

            if (
                    (fechaEntrada.isEqual(fechaInicioLocalDate) || fechaEntrada.isAfter(fechaInicioLocalDate)) &&
                            (fechaEntrada.isEqual(fechaFinLocalDate) || fechaEntrada.isBefore(fechaFinLocalDate))
            ) {
                System.out.println(entrada); // SOLO imprime si cumple la condición
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se han encontrado entradas en el rango de fechas indicado.");
        }

    }

}
