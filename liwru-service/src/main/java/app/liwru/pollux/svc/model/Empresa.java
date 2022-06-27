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
public class Empresa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idEmpresa;
    private String rucEmpresa;
    private String telefonoEmpresa;
    private String descripcionEmpresa;
    private LocalDate createAt;
    private String updateAt;


}
