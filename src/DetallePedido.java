public class DetallePedido {

    private Long id;
    private int cantidad;
    private double subTotal;

    // Relación con Articulo
    private Articulo articulo;

    // Constructor, Getters y Setters
    public DetallePedido(Long id, int cantidad, double subTotal, Articulo articulo) {
        this.id = id;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.articulo = articulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
