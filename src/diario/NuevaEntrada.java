package diario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.IOException;




public class NuevaEntrada implements Serializable {

    //Atributos
    protected String fecha;
    protected String nota;
    protected int id;

    //Constructor
    public NuevaEntrada(String fecha, String nota) {
        this.fecha = fecha;
        this.nota = nota;
        this.id = ultimaEntrada();
    }
    // Constructor con ID fijo para reconstrucción desde fichero
    public NuevaEntrada(int id, String fecha, String nota) {
        this.id = id;
        this.fecha = fecha;
        this.nota = nota;
    }

    //Getters y Setters
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }
    public int getId() {
        return id;
    }


    public static int ultimaEntrada() {
            // Leer el fichero donde está el último número
            String archivo = "id.txt";
            int id = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea = br.readLine();
                if (linea != null) {
                    id = Integer.parseInt(linea.trim());
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            int nuevoId = id + 1;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write(String.valueOf(nuevoId));
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }

            return nuevoId;
        }

    public String getTipoEntrada() {
        return "general";
    }
@Override
    public String toString() {
        return id + "|"
                + fecha + "|"
                + getTipoEntrada() + "|"
                + nota;
    }
    // Método para exportar a csv
    public String toCSV() {
        return id + ";" + fecha + ";" + getTipoEntrada() + ";" + nota;
    }

}
