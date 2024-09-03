package modelo3;
import lombok.*;
import lombok.experimental.SuperBuilder;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public class Imagen {
    private long id;
    private String nombre;
    private String url;
}
