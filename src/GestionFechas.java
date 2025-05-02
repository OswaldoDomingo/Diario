import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

}
