package diario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            if(scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                opciones(opcion, scanner); // Llamar al método de opciones
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // Limpiar el input incorrecto
            }
        } while (opcion != 3);
    }


    //Menu
    public static void menu() {
        System.out.println("*************************************");
        System.out.println("1. Añadir entrada");
        System.out.println("2. Ver entradas");
        System.out.println("3. Salir");
        System.out.println("4. Exportar binario a texto");
        System.out.println("5. Leer archivo de texto generado");
//        System.out.println("6. Borrar archivo de texto");
//        System.out.println("7. Buscar entrada por palabra");
//        System.out.println("8. Buscar entrada por fecha");
        System.out.println("6. Sección borrados");
        System.out.println("*************************************");
    }
    //Método para elegir la opción
    public static void opciones(int opcion, Scanner scanner) {
        System.out.println("*************************************");
        switch (opcion) {
            case 1:
                nuevaEntrada(scanner);
                break;
            case 2:
                verEntradas();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            case 4:
                System.out.println("Crear diario a texto");
                GestionFicherosBin.pasarDeBinarioATexto();
                break;
            case 5:
                System.out.println("Leer diario formato texto");
                GestionFicheros.leerFicheroTexto();
                break;
            case 6:
                //System.out.println("Borrar diario formato texto");
                //GestionFicheros.borrarArchivoTexto();
                MenuBorrados menuBorrados = new MenuBorrados();
                menuBorrados.mostrarMenu(scanner, GestionFicherosBin.leerFichero(""));
                break;
            case 7:
                System.out.println("Buscar entrada por palabra");
                System.out.println("Introduce la palabra a buscar:");
                String palabra = scanner.nextLine();
                GestionFicherosBin.buscarPorPalabra(palabra);
                break;
            case 8:
                System.out.println("Buscar entrada por fecha");
                System.out.println("Introduce la fecha a buscar (dd-MM-yyyy):");
                String fecha = scanner.nextLine();
                GestionFicherosBin.buscarPorFecha(fecha);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        System.out.println("*************************************");
    }

    //Método para añadir una entrada
    public static void nuevaEntrada(Scanner scanner) {
        //scanner.nextInt(); //Limpia el buffer
        String fecha = "";
        String nota = "";

        int tipoEntrada = seleccionarTipoEntrada(scanner);
        NuevaEntrada nuevaEntrada = null;

         switch (tipoEntrada) {
            case 1:
                System.out.println("Diario personal seleccionado");
                nuevaEntrada = crearEntradaDiario(scanner);
                break;
            case 2:
                System.out.println("Reflexión personal seleccionada");
                nuevaEntrada = crearReflexionPersonal(scanner);
                break;
            case 3:
                System.out.println("Apuntes de clase seleccionados");
                nuevaEntrada = crearApunteEstudio(scanner);
                break;
            case 4:
                System.out.println("Frases célebres seleccionadas");
                nuevaEntrada = crearFraseCelebre(scanner);
                break;
            case 5:
                 System.out.println("Apunte de libro seleccionado");
                 nuevaEntrada = crearApunteLibro(scanner);
                 break;
            default:
                System.out.println("Opción no válida");
        }


        ArrayList<NuevaEntrada> entrada = new ArrayList<>();
//        nuevaEntrada = new NuevaEntrada(fecha, nota);

        entrada.add(nuevaEntrada);

        // Guardar la entrada en el fichero por defecto (diario.dat)
        if (nuevaEntrada != null) {
            GestionFicherosBin.escribirFicheroArray(nuevaEntrada, ""); // Guardar en diario.dat
        }
    }

        //Método para ver las entradas
    public static void verEntradas(){
        //Ver entradas del fichero binario
        System.out.println("Entradas del fichero binario:");
        ArrayList<NuevaEntrada> entradasBin = GestionFicherosBin.leerFichero("");
        for(NuevaEntrada e : entradasBin) {
            System.out.println(e.toString());
        }
    }

    public static int seleccionarTipoEntrada(Scanner scanner) {
        System.out.println("Selecciona el tipo de entrada:");
        System.out.println("1. Diario personal");
        System.out.println("2. Reflexión personal");
        System.out.println("3. Apuntes de clase");
        System.out.println("4. Frases célebres");
        System.out.println("5. Apuntes de libros");
        System.out.println("0. Cancelar");

        return scanner.nextInt(); // Devuelve la opción elegida

    }
    //***********************************************
    //Métodos para crear entradas
    //***********************************************

    //Método para crear una entrada de diario
    public static NuevaEntrada crearEntradaDiario(Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer

        String fecha = GestionFechas.pedirFecha();

        //🔁 Permitir elegir el tipo de entrada (diario, reflexión, apunte, frase, etc.)
        System.out.println("Introduce la nota:");
        String nota = scanner.nextLine();
        return new NuevaEntrada(fecha, nota);
    }

    //Método para crear una entrada de apuntes de estudio
    public static ApunteEstudio crearApunteEstudio(Scanner scanner){
        scanner.nextLine(); //Limpiar el buffer
        String fecha = GestionFechas.pedirFecha();
        System.out.println("Ahora debes introducir Materia, Tema y Subtema");
        System.out.println("Introduce la materia:");
        String materia = scanner.nextLine();
        System.out.println("Introduce el tema:");
        String tema = scanner.nextLine();
        System.out.println("Introduce el subtema:");
        String subtema = scanner.nextLine();
        System.out.println("Introduce la nota:");
        String nota = scanner.nextLine();

        // Validamos que nada esté vacío
        if (materia.isEmpty() || tema.isEmpty() || subtema.isEmpty() || nota.isEmpty()) {
            System.out.println("Campos vacíos. Entrada no creada.");
            return null;
        }
        return new ApunteEstudio(fecha, nota, materia, tema, subtema);
    }

    //Método para crear una entrada de reflexión
    public static ReflexionPersonal crearReflexionPersonal(Scanner scanner){
        scanner.nextLine(); //Limpiar el buffer

        String fecha = GestionFechas.pedirFecha();

        System.out.println("Tipos de reflexiones:\nPersonales\nFilosóficas\nIntelectuales\nEmocionales\nCreativas\nDiarias\nEspirituales o Religiosas\n" +
                "Críticas\nProfesionales\n...");
        System.out.println("Introduce el tipo de reflexión:");
        String reflexion = scanner.nextLine();
        System.out.println("Introduce la reflexión:");
        String nota = scanner.nextLine();

        // Validamos que nada esté vacío
        if(reflexion.isEmpty() || nota.isEmpty()) {
            System.out.println("Campos vacíos. Entrada no creada.");
            return null;
        }

        return new ReflexionPersonal(fecha, nota, reflexion);
    }

    //Método para crear una entrada de frase célebre
    public static FraseCelebre crearFraseCelebre(Scanner scanner){
        scanner.nextLine();//Limpiar el buffer
        String fecha = GestionFechas.pedirFecha();
        System.out.println("Introduce la frase célebre:");
        String frase = scanner.nextLine();
        System.out.println("Introduce el autor:");
        String autor = scanner.nextLine();
        // Validamos que nada esté vacío
        if(frase.isEmpty() || autor.isEmpty()) {
            System.out.println("Campos vacíos. Entrada no creada.");
            return null;
        }
        return new FraseCelebre(fecha, frase, autor);
    }

    //Método para crear una entrada de apuntes de libros

    public static ApunteLibro crearApunteLibro(Scanner scanner) {

        scanner.nextLine();//Limpiar el buffer

        String fecha = GestionFechas.pedirFecha();

        System.out.println("Introduce el título del libro:");
        String titulo = scanner.nextLine();

        System.out.println("Introduce el autor del libro:");
        String autor = scanner.nextLine();

        System.out.println("Introduce la página del libro:");
        boolean correcto = false;
        int pagina = 0;
        // Bucle para validar la entrada de la página
        while (!correcto) {
            try {

                pagina = Integer.parseInt(scanner.nextLine());
                correcto = true; // Si se convierte correctamente, salimos del bucle

            } catch (NumberFormatException e) {
                System.out.println("Error al introducir la página. Debe ser un número.");
            }
        }
        System.out.println("Tipos de apuntes para un libro:\nResumen\nCita (Texto exacto del libro)\n" +
                "Idea Principal\nPregunta (Duda o reflexión surgida)\n" +
                "Conexión Personal (Relación con tu vida o experiencias)\n" +
                "Crítica/Opinión\nDefinición (Término o concepto importante)\n" +
                "Ejemplo\n...");
        System.out.println("Introduce el tipo de apunte:");
        String tipoDeApunte = scanner.nextLine();
        System.out.println("Introduce la nota:");
        String nota = scanner.nextLine();

        // Validamos que nada esté vacío
        if (titulo.isEmpty() || autor.isEmpty() || tipoDeApunte.isEmpty() || nota.isEmpty()) {
            System.out.println("Campos vacíos. Entrada no creada.");
            return null;
        }
        return new ApunteLibro(fecha, nota, titulo, autor, tipoDeApunte, pagina);

    }
}
