package app.liwru.pollux.client.service;

import app.liwru.pollux.client.dto.EmpresaDTO;
import app.liwru.pollux.client.dto.EmpresaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class EmpresaService {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private static final String EMPRESA_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/empresas";
    private final RestTemplate restTemplate;

    public EmpresaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<EmpresaDTO>> getEmpresas() {

        List<EmpresaDTO> empresas = null;
        ResponseEntity<EmpresaDTO[]> empresaResponse = restTemplate.getForEntity(EMPRESA_ENDPOINT, EmpresaDTO[].class);
        if (empresaResponse.getStatusCode().is2xxSuccessful()) {
            EmpresaDTO[] body = empresaResponse.getBody();
            List<EmpresaDTO> emp = Arrays.asList(body);
            empresas = emp;
        }
        return Optional.of(empresas);
    }

    public void updateEmpresa(EmpresaDTO empresaDTO){
        HttpEntity<EmpresaDTO> request = new HttpEntity<>(empresaDTO);
        restTemplate.put(EMPRESA_ENDPOINT, request, EmpresaDTO.class);
    }

    public Optional<EmpresaDTO> getEmpresa(Integer id) {

        EmpresaDTO empresa = null;
        ResponseEntity<EmpresaDTO> empresaResponse = restTemplate.getForEntity(EMPRESA_ENDPOINT+"/"+id, EmpresaDTO.class);
        if (empresaResponse.getStatusCode().is2xxSuccessful()) {
            EmpresaDTO body = empresaResponse.getBody();
            EmpresaDTO usu = body;

            empresa = usu;
        }
        return Optional.of(empresa);
    }

}
