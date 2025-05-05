package test;

import diario.GestionFechas;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GestionFechasTest {

    // Test para verificar que obtenerFecha devuelve algo no nulo y con formato válido
    @Test
    public void testObtenerFecha() {
        String fecha = GestionFechas.obtenerFecha();
        assertNotNull(fecha); // Comprobamos que no sea null

        LocalDate convertida = GestionFechas.convertirStringALocalDate(fecha);
        assertNotNull(convertida); // Comprobamos que se pueda convertir correctamente
    }

    // Test para una fecha válida
    @Test
    public void testConvertirFechaValida() {
        String fecha = "04-05-2025";
        LocalDate esperada = LocalDate.of(2025, 5, 4);

        LocalDate resultado = GestionFechas.convertirStringALocalDate(fecha);
        assertEquals(esperada, resultado); // Comprobamos que sea la fecha correcta
    }

    // Test para una fecha inválida (formato incorrecto)
    @Test
    public void testConvertirFechaInvalida() {
        String fecha = "2025/05/04"; // Mal formato
        LocalDate resultado = GestionFechas.convertirStringALocalDate(fecha);
        assertNull(resultado); // Debe devolver null
    }

    // Test para fecha vacía y null
    @Test
    public void testConvertirFechaVaciaONula() {
        // Cadena vacía
        String fechaVacia = "";
        LocalDate resultadoVacia = GestionFechas.convertirStringALocalDate(fechaVacia);
        assertNull(resultadoVacia);

        // null
        String fechaNula = null;
        LocalDate resultadoNula = GestionFechas.convertirStringALocalDate(fechaNula);
        assertNull(resultadoNula);
    }


}
