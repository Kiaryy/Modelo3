@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Articulo {

    private Long id;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private int tiempoEstimadoMinutos;
    
    private UnidadMedida unidad;
    private Imagenes imagen;
}