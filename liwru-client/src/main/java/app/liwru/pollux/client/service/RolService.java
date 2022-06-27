package app.liwru.pollux.client.service;

import app.liwru.pollux.client.dto.RolDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class RolService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

   private static final String ROLES_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/roles";



    private final RestTemplate restTemplate;

    public RolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<RolDTO>> getRoles() {

        List<RolDTO> roles = null;
        ResponseEntity<RolDTO[]> rolResponse = restTemplate.getForEntity(ROLES_ENDPOINT, RolDTO[].class);
        if (rolResponse.getStatusCode().is2xxSuccessful()) {
            RolDTO[] body = rolResponse.getBody();
            List<RolDTO> rol = Arrays.asList(body);
            roles = rol;
        }
        return Optional.of(roles);
    }






}
