package app.liwru.pollux.svc.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idEstado;
    private String estadoDescripcion;

}
