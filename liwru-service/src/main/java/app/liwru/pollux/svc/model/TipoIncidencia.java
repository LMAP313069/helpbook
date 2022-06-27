package app.liwru.pollux.svc.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tipoIncidencia")
public class TipoIncidencia {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTipoIncidencia;
    private String descripcion;

}
