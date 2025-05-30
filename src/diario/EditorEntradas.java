package diario;

import java.util.ArrayList;
import java.util.Scanner;

public class EditorEntradas {

    public void editarEntrada(ArrayList<NuevaEntrada> entradas,int id){

        for(NuevaEntrada entrada : entradas){
            if(entrada.getId() == id){
                System.out.println(entrada.getId());
                System.out.println(entrada.getFecha());
                System.out.println(entrada.getNota());
                // Ya tienes el objeto y su posición i
                // Ahora puedes hacer un switch o if para ver su tipo
                if (entrada instanceof ApunteLibro) {

                    editarApunteLibro((ApunteLibro) entrada, new Scanner(System.in));
                    System.out.println("Editando un ApunteLibro");
                    System.out.println(entrada.toString());

                } else if (entrada instanceof ReflexionPersonal) {

                    editarReflexion((ReflexionPersonal) entrada, new Scanner(System.in));
                    System.out.println("Editando una ReflexionPersonal");
                    System.out.println(entrada.toString());

                } else if (entrada instanceof FraseCelebre) {

                    editarFrase((FraseCelebre) entrada, new Scanner(System.in));
                    System.out.println("Editando una FraseCelebre");
                    System.out.println(entrada.toString());

                } else if (entrada instanceof ApunteEstudio) {

                    editarApunteEstudio((ApunteEstudio) entrada, new Scanner(System.in));
                    System.out.println("Editando un ApunteEstudio");
                    System.out.println(entrada.toString());

                } else {
                    System.out.println("Tipo de entrada desconocido.");
                }

                // Aquí podrías guardar todo el ArrayList al fichero binario si deseas
                GestionFicherosBin.escribirFichero(entradas, "diario.dat");

                return; // salir tras modificar
            }
        }
    }

    private void editarApunteLibro(ApunteLibro entrada, Scanner sc) {
        System.out.println("Fecha actual: " + entrada.getFecha());
        System.out.print("Introduce la nueva fecha (o presiona Enter para mantener la actual): ");
        String nuevaFecha = sc.nextLine();
        if (!nuevaFecha.isEmpty()) {
            entrada.setFecha(nuevaFecha);
        }
        System.out.println("Nota actual: " + entrada.getNota());
        System.out.print("Introduce la nueva nota (o presiona Enter para mantener la actual): ");
        String nuevaNota = sc.nextLine();
        if (!nuevaNota.isEmpty()) {
            entrada.setNota(nuevaNota);
        }
        System.out.println("Libro actual: " + entrada.getLibro());
        System.out.print("Introduce el nuevo libro (o presiona Enter para mantener el actual): ");
        String nuevoLibro = sc.nextLine();
        if (!nuevoLibro.isEmpty()) {
            entrada.setLibro(nuevoLibro);
        }
        System.out.println("Autor actual: " + entrada.getAutor());
        System.out.print("Introduce el nuevo autor (o presiona Enter para mantener el actual): ");
        String nuevoAutor = sc.nextLine();
        if (!nuevoAutor.isEmpty()) {
            entrada.setAutor(nuevoAutor);
        }
        System.out.println("Página actual: " + entrada.getPagina());
        System.out.print("Introduce la nueva página (o presiona Enter para mantener la actual): ");
        String nuevaPagina = sc.nextLine();
        if (!nuevaPagina.isEmpty()) {
            try {
                entrada.setPagina(Integer.parseInt(nuevaPagina));
            } catch (NumberFormatException e) {
                System.out.println("Página no válida, manteniendo la actual.");
            }
        }


    }

    private void editarReflexion(ReflexionPersonal entrada, Scanner sc) {
        System.out.println("Fecha actual: " + entrada.getFecha());
        System.out.print("Introduce la nueva fecha (o presiona Enter para mantener la actual): ");
        String nuevaFecha = sc.nextLine();
        if (!nuevaFecha.isEmpty()) {
            entrada.setFecha(nuevaFecha);
        }

        //Solo se edita la nota en ReflexionPersonal
        System.out.println("Nota actual: " + entrada.getNota());
        System.out.print("Introduce la nueva nota (o presiona Enter para mantener la actual): ");
        String nuevaNota = sc.nextLine();
        if (!nuevaNota.isEmpty()) {
            entrada.setNota(nuevaNota);
        }

    }

    private void editarFrase(FraseCelebre entrada, Scanner sc) {
        System.out.println("Fecha actual: " + entrada.getFecha());
        System.out.print("Introduce la nueva fecha (o presiona Enter para mantener la actual): ");
        String nuevaFecha = sc.nextLine();
        if (!nuevaFecha.isEmpty()) {
            entrada.setFecha(nuevaFecha);
        }
        System.out.println("Nota actual: " + entrada.getNota());
        System.out.print("Introduce la nueva frase (o presiona Enter para mantener la actual): ");
        String nuevaNota = sc.nextLine();
        if (!nuevaNota.isEmpty()) {
            entrada.setNota(nuevaNota);
        }
        System.out.println("Autor actual: " + entrada.getAutor());
        System.out.print("Introduce el nuevo autor (o presiona Enter para mantener el actual): ");
        String nuevoAutor = sc.nextLine();
        if (!nuevoAutor.isEmpty()) {
            entrada.setAutor(nuevoAutor);
        }

    }

    private void editarApunteEstudio(ApunteEstudio entrada, Scanner sc){
        //Lo que se pretende es editar del apunte es la fecha y la nota
        //Si se quiere editar la materia, se borra el apunte y se crea uno nuevo

        System.out.println("Fecha actual: " + entrada.getFecha());
        System.out.print("Introduce la nueva fecha (o presiona Enter para mantener la actual): ");
        String nuevaFecha = sc.nextLine();
        if (!nuevaFecha.isEmpty()) {
            entrada.setFecha(nuevaFecha);
        }


        System.out.println("Tema actual: " + entrada.getTema());
        System.out.print("Introduce el nuevo tema (o presiona Enter para mantener el actual): ");
        String nuevoTema = sc.nextLine();
        if (!nuevoTema.isEmpty()) {
            entrada.setTema(nuevoTema);
        }
        System.out.println("Subtema actual: " + entrada.getSubtema());
        System.out.print("Introduce el nuevo subtema (o presiona Enter para mantener el actual): ");
        String nuevoSubtema = sc.nextLine();
        if (!nuevoSubtema.isEmpty()) {
            entrada.setSubtema(nuevoSubtema);
        }

        System.out.println("Nota actual: " + entrada.getNota());
        System.out.print("Introduce la nueva nota (o presiona Enter para mantener la actual): ");
        String nuevaNota = sc.nextLine();
        if (!nuevaNota.isEmpty()) {
            entrada.setNota(nuevaNota);
        }
        System.out.println("✅ Apunte de estudio modificado correctamente.");

    }



}
