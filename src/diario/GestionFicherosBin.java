package diario;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class GestionFicherosBin implements Serializable {

    // Escribe una entrada en el fichero binario (modo lista completa)
    public static void escribirFicheroArray(NuevaEntrada entrada, String nombreFichero) {
        if (entrada == null) {
            System.out.println("La entrada no puede ser nula.");
            return;
        }

        String fichero = (nombreFichero == null || nombreFichero.isEmpty()) ? "diario.dat" : nombreFichero;

        ArrayList<NuevaEntrada> diario = leerFichero(fichero);
        diario.add(entrada);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(diario);
            System.out.println("Entrada guardada correctamente en el fichero binario: " + fichero);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void escribirFichero(ArrayList<NuevaEntrada> entradas, String nombreFichero) {
        if (entradas == null) {
            System.out.println("La lista de entradas no puede ser nula.");
            return;
        }

        String fichero = (nombreFichero == null || nombreFichero.isEmpty()) ? "diario.dat" : nombreFichero;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(entradas); // Se escribe directamente la lista pasada
            System.out.println("Fichero binario actualizado correctamente: " + fichero);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }


    // Lee un fichero binario y devuelve una lista de entradas
    public static ArrayList<NuevaEntrada> leerFichero(String nombreFichero) {
        ArrayList<NuevaEntrada> diario = new ArrayList<>();
        String fichero = (nombreFichero == null || nombreFichero.isEmpty()) ? "diario.dat" : nombreFichero;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            diario = (ArrayList<NuevaEntrada>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe: " + fichero);
        } catch (EOFException e) {
            System.out.println("El fichero está vacío: " + fichero);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        return diario;
    }

    // Busca entradas que contienen una palabra (versión testable)
    public static List<NuevaEntrada> filtrarPorPalabra(String palabra, String nombreFichero) {
        ArrayList<NuevaEntrada> diario = leerFichero(nombreFichero);
        List<NuevaEntrada> resultados = new ArrayList<>();
        for (NuevaEntrada entrada : diario) {
            if (entrada.getNota().toLowerCase().contains(palabra.toLowerCase())) {
                resultados.add(entrada);
            }
        }
        return resultados;
    }

    // Variante para uso normal (diario.dat)
    public static List<NuevaEntrada> filtrarPorPalabra(String palabra) {
        return filtrarPorPalabra(palabra, "");
    }

    // Busca entradas por fecha (versión testable)
    public static List<NuevaEntrada> filtrarPorFecha(String fecha, String nombreFichero) {
        ArrayList<NuevaEntrada> diario = leerFichero(nombreFichero);
        List<NuevaEntrada> resultados = new ArrayList<>();

        LocalDate fechaLocalDate = GestionFechas.convertirStringALocalDate(fecha);
        if (fechaLocalDate == null) {
            System.out.println("Formato de fecha inválido: " + fecha);
            return resultados;
        }

        for (NuevaEntrada entrada : diario) {
            LocalDate fechaEntrada = GestionFechas.convertirStringALocalDate(entrada.getFecha());
            if (fechaEntrada != null && fechaLocalDate.isEqual(fechaEntrada)) {
                resultados.add(entrada);
            }
        }

        return resultados;
    }

    // Variante para uso normal (diario.dat)
    public static List<NuevaEntrada> filtrarPorFecha(String fecha) {
        return filtrarPorFecha(fecha, "");
    }

    // Método que imprime todas las entradas que contienen una palabra (modo consola)
    public static void buscarPorPalabra(String palabra) {
        List<NuevaEntrada> resultados = filtrarPorPalabra(palabra);
        if (resultados.isEmpty()) {
            System.out.println("No se ha encontrado ninguna entrada con la palabra: " + palabra);
        } else {
            for (NuevaEntrada e : resultados) {
                System.out.println(e);
            }
            System.out.println("Se han encontrado " + resultados.size() + " entradas con la palabra: " + palabra);
        }
    }

    // Método que imprime todas las entradas de una fecha concreta
    public static void buscarPorFecha(String fecha) {
        List<NuevaEntrada> resultados = filtrarPorFecha(fecha);
        if (resultados.isEmpty()) {
            System.out.println("No se ha encontrado ninguna entrada con la fecha: " + fecha);
        } else {
            for (NuevaEntrada e : resultados) {
                System.out.println(e);
            }
            System.out.println("Se han encontrado " + resultados.size() + " entradas con la fecha: " + fecha);
        }
    }

    // Exporta el contenido del binario a texto y CSV
    public static void pasarDeBinarioATexto() {
        String ficheroTexto = "diario.txt";
        String ficheroCSV = "diario.csv";
        String ficheroBinario = "diario.dat";

        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroBinario));
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroTexto));
                BufferedWriter bwcsv = new BufferedWriter(new FileWriter(ficheroCSV))
        ) {
            ArrayList<NuevaEntrada> lista = (ArrayList<NuevaEntrada>) ois.readObject();

            bwcsv.write("ID;Fecha;Nota");
            bwcsv.newLine();
            for (NuevaEntrada entrada : lista) {
                bw.write(entrada.toString());
                bw.newLine();

                bwcsv.write(entrada.toCSV());
                bwcsv.newLine();
            }

            System.out.println("El fichero de texto se ha generado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero binario: " + ficheroBinario);
        } catch (EOFException e) {
            System.out.println("El fichero binario está vacío.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al procesar el fichero: " + e.getMessage());
        }
    }

    // Verifica si el fichero está vacío
    public static boolean ficheroVacio(String nombreFichero) {
        File file = new File(nombreFichero);
        return file.exists() && file.length() == 0;
    }
}
