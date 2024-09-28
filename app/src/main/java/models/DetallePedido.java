import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class DetallePedido {
    private long id;
    private int cantidad;
    private Double subTotal;
    Articulo articulo;
}
