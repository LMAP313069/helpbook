package app.liwru.pollux.svc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idDocumento;
    private String urlDocumento;
    private Integer idIncidencia;
}
