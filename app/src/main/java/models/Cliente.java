import java.time.LocalDate;
import java.util.HashSet;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Cliente {
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    HashSet<Pedido> hace = new HashSet<Pedido>();
}
