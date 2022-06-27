package app.liwru.pollux.client.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class  SedeDTO {


    private Integer idSede;
    private String nombre;
    private String direccion;
    private Integer estado;
    private String gerente;
    private String telefono;
    private Integer idEmpresa;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private LocalDate deletedAt;
    private EmpresaDTO empresa;



}
