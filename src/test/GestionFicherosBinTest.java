package test;

import diario.GestionFicherosBin;
import diario.NuevaEntrada;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionFicherosBinTest {

    private static final String FICHERO_TEST = "diario.test.dat";

    @BeforeEach
    public void preparar() {
        // Eliminar el fichero de test si ya existe
        File binario = new File(FICHERO_TEST);
        if (binario.exists()) {
            binario.delete();
        }

        // Crear entradas de prueba
        ArrayList<NuevaEntrada> lista = new ArrayList<>();
        lista.add(new NuevaEntrada(1, "06-05-2025", "Hoy he practicado Java 2."));
        lista.add(new NuevaEntrada(2, "05-05-2025", "Una nota adicional sin esa palabra 2."));

        // Guardar en el fichero binario de test
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_TEST))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            System.out.println("Error al preparar el fichero de test: " + e.getMessage());
        }
    }

    @AfterEach
    public void limpiar() {
        // Eliminar el fichero de test después de cada prueba (opcional)
        File binario = new File(FICHERO_TEST);
        if (binario.exists()) {
            binario.delete();
        }
    }

    @Test
    public void testFiltrarPorPalabraEncontrada() {
        List<NuevaEntrada> resultados = GestionFicherosBin.filtrarPorPalabra("java", FICHERO_TEST);
        assertFalse(resultados.isEmpty(), "No se encontraron entradas con la palabra 'java'");
        assertTrue(resultados.get(0).getNota().toLowerCase().contains("java"));
    }

    @Test
    public void testFiltrarPorPalabraNoEncontrada() {
        List<NuevaEntrada> resultados = GestionFicherosBin.filtrarPorPalabra("inexistente", FICHERO_TEST);
        assertTrue(resultados.isEmpty(), "Se encontraron entradas con una palabra que no debería existir");
    }

    @Test
    public void testFiltrarPorFechaValida() {
        List<NuevaEntrada> resultados = GestionFicherosBin.filtrarPorFecha("06-05-2025", FICHERO_TEST);
        assertFalse(resultados.isEmpty(), "No se encontraron entradas para la fecha 06-05-2025");
        assertEquals("06-05-2025", resultados.get(0).getFecha());
    }

    @Test
    public void testFiltrarPorFechaInvalida() {
        List<NuevaEntrada> resultados = GestionFicherosBin.filtrarPorFecha("99-99-9999", FICHERO_TEST);
        assertTrue(resultados.isEmpty(), "Se encontraron entradas para una fecha inválida");
    }
}
