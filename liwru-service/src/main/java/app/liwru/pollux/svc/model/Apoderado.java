package app.liwru.pollux.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apoderado {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idApoderado;
    private String apoderadoNombre;
    private String apoderadoApellidoPat;
    private String apoderadoApellidoMat;
    private String apoderadoTelefono;
    private String apoderadoEmail;
    private String apoderadoNroDoc;
    private Integer idTipoDoc;
    private LocalDate createdAt;
    private LocalDate updatedAt;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idTipoDoc",referencedColumnName = "idTipoDoc", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDocumento tipoDocumento;
}
