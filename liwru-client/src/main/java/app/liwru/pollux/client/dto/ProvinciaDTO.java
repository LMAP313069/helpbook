package app.liwru.pollux.client.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaDTO {

    private Integer idProvincia;
    private String nombre;
    private DepartamentoDTO departamento;
}
