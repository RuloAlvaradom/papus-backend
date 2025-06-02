package com.papus.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuariosApplication.class, args);
    }

    // Permite hacer llamadas HTTP entre microservicios
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
