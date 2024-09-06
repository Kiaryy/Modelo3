public class UnidadMedida {

    private Long id;
    private String denominacion;

    // Constructor, Getters y Setters
    public UnidadMedida(Long id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
