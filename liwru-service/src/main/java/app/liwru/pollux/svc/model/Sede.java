package app.liwru.pollux.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sede {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idSede;
    private String nombre;
    private String direccion;
    private Integer estado;
    private String gerente;
    private String telefono;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private LocalDate deletedAt;
    private Integer idEmpresa;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa",insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;


}
