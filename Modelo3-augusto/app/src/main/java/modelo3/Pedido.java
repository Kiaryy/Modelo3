package modelo3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import lombok.*;
import lombok.experimental.SuperBuilder;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Pedido {
    private long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    HashSet<DetallePedido> detalles = new HashSet<DetallePedido>();

    // Enum para Estado
    public enum Estado {
        PENDIENTE,
        PROCESANDO,
        ENVIADO,
        ENTREGADO,
        CANCELADO
    }

    // Enum para TipoEnvio
    public enum TipoEnvio {
        ESTANDAR,
        EXPRESO,
        INTERNACIONAL
    }

    // Enum para FormaPago
    public enum FormaPago {
        TARJETA_CREDITO,
        TARJETA_DEBITO,
        PAYPAL,
        TRANSFERENCIA_BANCARIA
    }
}
