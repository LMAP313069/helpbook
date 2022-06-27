package app.liwru.pollux.client.service;

import app.liwru.pollux.client.dto.EstadoDTO;
import app.liwru.pollux.client.dto.EstadoDTO;
import app.liwru.pollux.client.dto.EstadoDTO;
import app.liwru.pollux.client.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class EstadoService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

   private static final String ESTADOS_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/estados";


    private final RestTemplate restTemplate;

    public EstadoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<EstadoDTO>> getEstados() {

        List<EstadoDTO> estados = null;
        ResponseEntity<EstadoDTO[]> usuarioResponse = restTemplate.getForEntity(ESTADOS_ENDPOINT, EstadoDTO[].class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            EstadoDTO[] body = usuarioResponse.getBody();
            List<EstadoDTO> usu = Arrays.asList(body);
            estados = usu;
        }
        return Optional.of(estados);
    }

    public EstadoDTO createEstado(EstadoDTO estadoDTO){
        HttpEntity<EstadoDTO> request = new HttpEntity<>(estadoDTO);
        EstadoDTO estadoDtoResponse = restTemplate.postForObject(ESTADOS_ENDPOINT, request, EstadoDTO.class);
        assert estadoDtoResponse != null;
        return estadoDtoResponse;
    }

    public void updateEstados(EstadoDTO estadoDTO){
        HttpEntity<EstadoDTO> request = new HttpEntity<>(estadoDTO);
        restTemplate.put(ESTADOS_ENDPOINT, request, EstadoDTO.class);
    }





}
