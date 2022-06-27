package app.liwru.pollux.client.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO {
    private Integer idDocumento;
    private String urlDocumento;
    private Integer idIncidencia;
}