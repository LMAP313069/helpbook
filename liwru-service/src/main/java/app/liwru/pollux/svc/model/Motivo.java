package app.liwru.pollux.svc.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motivo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idMotivo;
    private String estadoDescripcion;
    private Integer estadoMotivo;

}
