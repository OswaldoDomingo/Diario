import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NuevaEntrada implements Serializable {

    //Atributos
    private String fecha;
    private String nota;

    //Constructor
    public NuevaEntrada(String fecha, String nota) {
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

    @Override
    public String toString() {
        return fecha + "|" + nota;
    }



}
