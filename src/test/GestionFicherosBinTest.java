package test;
import diario.GestionFicherosBin;
import org.junit.jupiter.api.*;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class GestionFicherosBinTest {

        @BeforeEach
        public void preparar() {
            // Asegurarnos de que no exista el fichero antes de cada test
            File txt = new File("diario.txt");
            if (txt.exists()) {
                txt.delete();
            }
        }

        @Test
        public void testPasarDeBinarioATexto() {
            // Ejecutar el método que queremos probar
            GestionFicherosBin.pasarDeBinarioATexto();

            // Comprobar que se ha creado el archivo .txt
            File ficheroTexto = new File("diario.txt");
            assertTrue(ficheroTexto.exists(), "El archivo de texto no se ha creado correctamente");
        }
    @Test
    public void testArchivoTextoTieneContenido() {
        GestionFicherosBin.pasarDeBinarioATexto();

        File ficheroTexto = new File("diario.txt");

        assertTrue(ficheroTexto.exists(), "El archivo de texto no se ha creado correctamente");
        assertTrue(ficheroTexto.length() > 0, "El archivo de texto está vacío");
    }

    }



