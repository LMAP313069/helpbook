package app.liwru.pollux.svc.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTipoDoc;
    private String descripcion;

}
