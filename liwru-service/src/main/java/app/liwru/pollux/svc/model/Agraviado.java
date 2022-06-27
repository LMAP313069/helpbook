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
public class Agraviado {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idAgraviado;
    private String clienteNombre;
    private String clienteApeMat;
    private String clienteApePat;
    private String clienteEmail;
    private String clienteTelefono;
    private String clienteDireccion;
    private String clienteNroDoc;
    private Integer estatusEdad;
    private Integer estado;
    private Integer idTipoDoc;
    private Integer idApoderado;
    private Integer idDepartamento;
    private Integer idProvincia;
    private Integer idDistrito;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idDistrito", insertable = false, updatable = false)
    @JsonIgnoreProperties("idDistrito")
    private Distrito distrito;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idTipoDoc",referencedColumnName = "idTipoDoc", insertable = false, updatable = false)
    @JsonIgnoreProperties("idTipoDoc")
    private TipoDocumento tipoDocumento;


}
