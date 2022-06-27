package app.liwru.pollux.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String numeroDocUsuario;
    private String contrasena;
    private Integer estado;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
    @Column(name = "idRolUsuario")
    private Integer idRolUsuario;
    @Column(name = "idTipoDoc")
    private Integer idTipoDoc;

    @ManyToOne
    @JoinColumn(name = "idRolUsuario",insertable = false, nullable = false, updatable = false)
    @JsonIgnoreProperties("idRolUsuario")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idTipoDoc",insertable = false, nullable = false, updatable = false)
    @JsonIgnoreProperties("idTipoDoc")
    private TipoDocumento tipoDocumento;

}
