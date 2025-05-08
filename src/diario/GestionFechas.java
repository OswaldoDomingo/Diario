package diario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

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

}
