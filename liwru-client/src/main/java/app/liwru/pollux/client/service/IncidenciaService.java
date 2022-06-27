package app.liwru.pollux.client.service;

import app.liwru.pollux.client.dto.DepartamentoDTO;
import app.liwru.pollux.client.dto.IncidenciaDTO;
import app.liwru.pollux.client.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class IncidenciaService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private static final String INCIDENCIA_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/incidencias";
    private static final String INCIDENCIA_AGRAVIADO_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/incidencias/getPorAgraviado";


    private final RestTemplate restTemplate;




    public IncidenciaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<IncidenciaDTO>> getIncidencias() {

        List<IncidenciaDTO> incidencias = null;
        ResponseEntity<IncidenciaDTO[]> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_ENDPOINT, IncidenciaDTO[].class);
        if (incidenciaResponse.getStatusCode()== HttpStatus.OK) {
            IncidenciaDTO[] body = incidenciaResponse.getBody();
            List<IncidenciaDTO> inci = Arrays.asList(body);
            incidencias = inci;
        }
        return Optional.of(incidencias);
    }

    public Optional<List<IncidenciaDTO>> getIncidenciasPorAgraviado(Integer id) {

        List<IncidenciaDTO> incidencias = null;
        ResponseEntity<IncidenciaDTO[]> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_AGRAVIADO_ENDPOINT+"/"+id, IncidenciaDTO[].class);
        if (incidenciaResponse.getStatusCode()== HttpStatus.OK) {
            IncidenciaDTO[] body = incidenciaResponse.getBody();
            List<IncidenciaDTO> inci = Arrays.asList(body);
            incidencias = inci;
        }
        return Optional.of(incidencias);
    }

    public Optional<IncidenciaDTO> getIncidencia(Integer id) {

        IncidenciaDTO incidencia = null;
        ResponseEntity<IncidenciaDTO> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_ENDPOINT+"/"+id, IncidenciaDTO.class);
        if (incidenciaResponse.getStatusCode().is2xxSuccessful()) {
            IncidenciaDTO body = incidenciaResponse.getBody();
            IncidenciaDTO inci = (body);
            incidencia = inci;
        }
        return Optional.of(incidencia);
    }

    public void updateIncidencia(IncidenciaDTO incidenciaDTO){//Actualiza estado y al usuario
        HttpEntity<IncidenciaDTO> request = new HttpEntity<>(incidenciaDTO);
        restTemplate.put(INCIDENCIA_ENDPOINT, request, IncidenciaDTO.class);
    }

}
