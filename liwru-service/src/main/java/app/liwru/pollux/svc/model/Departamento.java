package app.liwru.pollux.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idDepartamento;
    private String nombre;

}
