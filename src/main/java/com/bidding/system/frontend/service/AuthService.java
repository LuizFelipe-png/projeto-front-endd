package com.bidding.system.frontend.service;

import com.bidding.system.frontend.model.UserDTO;
import com.bidding.system.frontend.model.UserRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthService {
    
    private final RestClient restClient;

    public AuthService() {
        this.restClient = RestClient.create("http://localhost:8080");
    }

    public String logar(UserRequestDTO user) {
        return restClient.post()
                .uri("/api/auth/logar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(String.class);
    }
    
    public void registrar(UserDTO user) {
        String retorno = restClient.post()
                .uri("/api/auth/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(String.class);
                
        System.out.println("Resposta do Back-end: " + retorno);
    }
}