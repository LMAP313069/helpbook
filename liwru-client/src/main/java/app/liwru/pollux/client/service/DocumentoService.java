package app.liwru.pollux.client.service;

import app.liwru.pollux.client.dto.AgraviadoDTO;
import app.liwru.pollux.client.dto.DocumentoDTO;
import app.liwru.pollux.client.dto.DocumentoDTO;
import app.liwru.pollux.client.dto.MotivoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DocumentoService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

   private static final String DOCUMENTOS_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/documentos/getByIdIncidencia";

   

    private final RestTemplate restTemplate;

    public DocumentoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<DocumentoDTO>> getDocumentosByIdIncidencia(Integer id) {

        List<DocumentoDTO> documentos = null;
        ResponseEntity<DocumentoDTO[]> documentoResponse = restTemplate.getForEntity(DOCUMENTOS_ENDPOINT +"/"+id, DocumentoDTO[].class);
        if (documentoResponse.getStatusCode().is2xxSuccessful()) {
            DocumentoDTO[] body = documentoResponse.getBody();
            List<DocumentoDTO> documento = Arrays.asList(body);
            documentos = documento;
        }
        return Optional.of(documentos);
    }






}
