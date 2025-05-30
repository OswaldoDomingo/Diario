package diario;

import java.io.*;
import java.util.ArrayList;


public class GestionFicheros {
 /*
    //********************************************************************************************
    //Por la nueva funcionalidad de escribir todo el fichero bin a txt, esta clase casi ya no es necesaria
    // se ha hecho el método leerFicheroTexto() para leer el fichero de texto cuando se genere.
    //********************************************************************************************
    //Método recibe una entrada y la escribe en el fichero

    public static void escribirFichero(NuevaEntrada entrada) {
        String fichero = "diario.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))){
            bw.write(entrada.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }

    }


    //Método que lee el fichero y devuelve un ArrayList con el contenido
    public static ArrayList<String> leerDiario(){
        String fichero = "diario.txt";
        ArrayList<String> diario = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea;
            while ((linea = br.readLine()) != null){
                diario.add(linea);
            }

        }catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
        return diario;

    }

    //Método que lee el fichero y devuelve un ArrayList con objetos NuevaEntrada

    public static ArrayList<NuevaEntrada> leerDiarioGuardarObjetos(){
        //Leer el fichero donde están guardados los datos
        String fichero = "diario.txt";
        //Crear un ArrayList de tipo NuevaEntrada
        ArrayList<NuevaEntrada> diario = new ArrayList<>();

        //Recorrer el fichero y guardar los datos en el ArrayList dde objetos NuevaEntrada
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea;
            if(!fichero.isEmpty()) {
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("\\|");
                    String id = partes[0];
                    String fecha = partes[1];
                    String nota = partes[2];
                    // ✅ Usamos el constructor con ID
                    NuevaEntrada entrada = new NuevaEntrada(Integer.parseInt(id), fecha, nota);
                    diario.add(entrada);
                }
            } else if (diario.isEmpty()) {
                System.out.println("El fichero está vacío");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return diario;

    }

    */

    public static void leerFicheroTexto() {
        String ficheroTexto = "diario.txt";
        File fichero = new File(ficheroTexto);

        if (!fichero.exists()) {
            System.out.println();
            System.out.println("******************************");
            System.out.println("El fichero de texto no existe.");
            System.out.println("******************************");
            System.out.println();

            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de texto: " + e.getMessage());
        }
    }

    //Método para borrar el archivo de texto
    public static void borrarArchivoTexto() {
        String ficheroTexto = "diario.txt";
        String ficheroCSV= "diario.csv";
        File archivo = new File(ficheroTexto);
        File archivoCSV = new File(ficheroCSV);

        if (!archivo.exists()) {
            System.out.println("El archivo de texto no existe.");
            return;
        }

        if (archivo.delete() && archivoCSV.delete()) {
            System.out.println("Archivo de texto y CSV borrados correctamente.");
        } else {
            System.out.println("No se pudo borrar algún archivo.");
        }
    }
}
