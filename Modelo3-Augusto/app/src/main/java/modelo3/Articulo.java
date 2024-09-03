package modelo3;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Articulo {
    private long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private int tiempoEstimadoMaximo;
    private UnidadMedida unidadMedida;
    private Imagen imagen;

}
