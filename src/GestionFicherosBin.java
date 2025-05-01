import java.io.*;
import java.util.ArrayList;

public class GestionFicherosBin  implements Serializable {


    public static void escribirFicheroClase(NuevaEntrada entrada) {
        // Define el nombre del fichero binario donde se guardarán los datos
        String fichero = "diario.dat";

        // Intenta abrir un flujo de salida para escribir objetos en el fichero
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(fichero, true))) {
            // Escribe el objeto `entrada` en el fichero
            oss.writeObject(entrada);
            // Muestra un mensaje indicando que la entrada se guardó correctamente
            System.out.println("Entrada guardada correctamente en el fichero binario.");
        } catch (Exception e) {
            // Captura cualquier excepción y muestra un mensaje de error
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    //Método que lee el fichero y devuelve un ArrayList con objetos NuevaEntrada
    public static void escribirFicheroArray(NuevaEntrada entrada) throws FileNotFoundException {

        String fichero = "diario.dat";
        // Crear un ArrayList de tipo NuevaEntrada
        ArrayList<NuevaEntrada> diario = leerFichero();

        if(ficheroVacio(fichero)) {

            try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(fichero, true))) {
                oss.writeObject(entrada);
                System.out.println("Entrada guardada correctamente en el fichero binario.");

            } catch (Exception e) {
                System.out.println("Error al escribir en el fichero: " + e.getMessage());

            }
        } else {

        }
    }

    //Método para comprobar si el fichero está vacío o no
    public static boolean ficheroVacio(String nombreFichero) {
        File file = new File(nombreFichero);
        return file.length() == 0;
    }

    public static ArrayList<NuevaEntrada> leerFichero() {
        //Leer el fichero donde están guardados los datos
        //Crear un ArrayList de tipo NuevaEntrada

        String fichero = "diario.dat";
        NuevaEntrada entrada;
        ArrayList<NuevaEntrada> diario = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))){

        }catch (IOException e){
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
