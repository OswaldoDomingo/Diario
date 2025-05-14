package diario;

public class ApunteLibro extends NuevaEntrada {
    //Atributos
    private String libro;
    private int pagina;
    private String autor;
    private String tipoDeApunte;

    //Constructor
    public ApunteLibro(String fecha, String nota, String libro, String autor, String tipoDeApunte, int pagina) {
        super(ultimaEntrada(), fecha, nota);
        this.libro = libro;
        this.pagina = pagina;
        this.autor = autor;
        this.tipoDeApunte = tipoDeApunte;
    }

    public String getTipoDeApunte() {
        return tipoDeApunte;
    }

    public void setTipoDeApunte(String tipoDeApunte) {
        this.tipoDeApunte = tipoDeApunte;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    @Override
    public String getTipoEntrada() {
        return "libro";
    }

    @Override
    public String toString() {
        return getId()
                + "|" + getFecha()
                + "|" + getTipoEntrada()
                + "|" + tipoDeApunte
                + "|" + libro
                + "|" + pagina
                + "|" + autor
                + "|" + getNota();
    }
    @Override
    public String toCSV() {
        return getId() + ";"
                + getFecha() + ";"
                + getTipoEntrada() + ";"
                + tipoDeApunte + ";"
                + libro + ";"
                + pagina + ";"
                + autor + ";"
                + getNota();
    }

}
