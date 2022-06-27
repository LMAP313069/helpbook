package app.liwru.pollux.svc.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idRolUsuario;
    private String descripcion;

}
