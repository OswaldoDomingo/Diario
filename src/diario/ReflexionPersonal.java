package diario;

public class ReflexionPersonal extends NuevaEntrada{

    private static final long serialVersionUID = 1L; // ✅ Añadido

    private String reflexion;

    //Constructor
    public ReflexionPersonal(String fecha, String nota, String reflexion) {
        super(ultimaEntrada(), fecha, nota);
        this.reflexion = reflexion;//Tipo de reflexion, alegría, tristeza, descubrimiento, etc.
    }

    //Getters y Setters
    public String getReflexion() {
        return reflexion;
    }

    public void setReflexion(String reflexion) {
        this.reflexion = reflexion;
    }

    @Override
    public String getTipoEntrada() {
        return "reflexion";
    }

    @Override
    public String toString() {
        return getId()
                + "|" + getFecha()
                + "|" + getTipoEntrada()
                + "|" + reflexion
                + "|" + getNota();
    }

    //Método para guardar en CSV
    @Override
    public String toCSV() {
        return getId() + ";"
                + getFecha() + ";"
                + getTipoEntrada() + ";"
                + reflexion + ";"
                + getNota();
    }
}
