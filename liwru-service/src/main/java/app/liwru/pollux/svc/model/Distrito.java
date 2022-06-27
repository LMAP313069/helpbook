package app.liwru.pollux.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idDistrito;
    private String nombre;
    private Integer idProvincia;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia", insertable = false, updatable = false)
    @JsonIgnoreProperties("idProvincia" )
    private Provincia provincia;

}
