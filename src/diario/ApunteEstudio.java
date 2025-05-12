package diario;

public class ApunteEstudio extends NuevaEntrada {

    private static final long serialVersionUID = 1L; // ✅ Añadido

    //materia, tema, subtema
    private String materia;
    private String tema;
    private String subtema;

    //Constructor
    public ApunteEstudio(String fecha, String nota, String materia, String tema, String subtema) {
        super(ultimaEntrada(),fecha, nota);
        this.materia = materia;
        this.tema = tema;
        this.subtema = subtema;

    }

    //Getters y Setters
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSubtema() {
        return subtema;
    }

    public void setSubtema(String subtema) {
        this.subtema = subtema;
    }

    @Override
    public String getTipoEntrada() {
        return "apunte";
    }

    @Override
    public String toString() {
        return getId()
                + "|" + getFecha()
                + "|" + getTipoEntrada()
                + "|" + materia
                + "|" + tema
                + "|" + subtema
                + "|" + getNota();
    }

    //Método para guardar en CSV
    @Override
    public String toCSV() {
        return getId() + ";"
                + getFecha() + ";"
                + getTipoEntrada() + ";"
                + materia + ";"
                + tema + ";"
                + subtema + ";"
                + getNota();
    }

}
