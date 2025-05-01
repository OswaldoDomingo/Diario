import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestionFechas {

    //Fecha
    public static String obtenerFecha() {
        //Obtenemos la fecha actual
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return fechaActual;
    }
}
