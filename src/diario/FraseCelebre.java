package diario;

public class FraseCelebre extends NuevaEntrada{

    private static final long serialVersionUID = 1L; // ✅ Añadido

    private String autor;

    //Constructor
    public FraseCelebre(String fecha, String nota, String autor) {
        super(ultimaEntrada(), fecha, nota);
        this.autor = autor;

    }
    //Getters y Setters
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    @Override
    public String getTipoEntrada() {
        return "frase";
    }

    @Override
    public String toString() {
        return getId()
                + "|" + getFecha()
                + "|" + getTipoEntrada()
                + "|" + autor
                + "|" + getNota();
    }


    //Método para guardar en CSV
    @Override
    public String toCSV() {
        return getId() + ";"
                + getFecha() + ";"
                + getTipoEntrada() + ";"
                + autor + ";"
                + getNota();
    }
}
