package diario;

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

    //Método que lee entrada y devuelve un ArrayList con objetos NuevaEntrada
    public static void escribirFicheroArray(NuevaEntrada entrada) {
        // Comprobar que la entrada no es nula
        if (entrada == null) {
            System.out.println("La entrada no puede ser nula.");
            return;
        }

        String fichero = "diario.dat";

        // Leer el ArrayList existente del fichero (o uno nuevo si no existe)
        ArrayList<NuevaEntrada> diario = leerFichero();

        // Añadir la nueva entrada al ArrayList
        diario.add(entrada);

        // Escribir TODO el ArrayList en el fichero (sobrescribiendo)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(diario);  // Guardamos la lista completa, no objetos individuales
            System.out.println("Entrada guardada correctamente en el fichero binario.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }


    //Método para comprobar si el fichero está vacío o no
    // Método que verifica si un fichero está vacío
    public static boolean ficheroVacio(String nombreFichero) {
        // Crea un objeto File con el nombre del fichero proporcionado
        File file = new File(nombreFichero);
        // Devuelve true si el tamaño del fichero es 0 (está vacío), de lo contrario devuelve false
        return file.exists() && file.length() == 0;
    }

    //Método que lee el fichero y devuelve un ArrayList con objetos NuevaEntrada
    public static ArrayList<NuevaEntrada> leerFichero() {
        //Leer el fichero donde están guardados los datos
        //Crear un ArrayList de tipo NuevaEntrada

        String fichero = "diario.dat"; // Nombre del fichero binario
        //NuevaEntrada entrada; // Declaración de la variable entrada
        ArrayList<NuevaEntrada> diario = new ArrayList<>();  // Inicialización del ArrayList

        //Escribir el fichero en el ArrayList
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))){
            diario = (ArrayList<NuevaEntrada>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Si el fichero no existe, devolvemos una lista vacía
            System.out.println("El fichero no existe. Se creará al guardar una entrada.");
        } catch (EOFException e) {
            // Si el fichero está vacío, devolvemos una lista vacía
            System.out.println("El fichero está vacío.");
        } catch (IOException | ClassNotFoundException e) {
            // Otras excepciones durante la lectura
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        // Devolvemos el ArrayList con las entradas leídas
        return diario;
    }

    // Método para leer el fichero binario y escribir su contenido en un fichero de texto
    public static void pasarDeBinarioATexto() {
        String ficheroTexto = "diario.txt";     // Fichero de salida
        String ficheroBinario = "diario.dat";   // Fichero de entrada

        try (
                // Crear ObjectInputStream para leer objetos
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroBinario));
                // Crear BufferedWriter para escribir texto
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroTexto))
        ) {
            // Leemos la lista de entradas desde el fichero binario
            ArrayList<NuevaEntrada> listaEntradas = (ArrayList<NuevaEntrada>) ois.readObject();

            // Escribimos cada entrada en el fichero de texto
            for (NuevaEntrada entrada : listaEntradas) {
                bw.write(entrada.toString());
                bw.newLine(); // salto de línea
            }

            System.out.println("El fichero de texto se ha generado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero binario: " + ficheroBinario);
        } catch (EOFException e) {
            System.out.println("El fichero binario está vacío.");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada al leer objeto: " + e.getMessage());
        }
    }

}
