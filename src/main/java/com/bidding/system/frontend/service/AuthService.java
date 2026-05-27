/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.service;

import com.bidding.system.frontend.model.UserDTO;
import com.bidding.system.frontend.model.UserRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço responsável por comunicação com a API de autenticação externa.
 */
@Service
public class AuthService {
    
    private final RestClient restClient;

    /**
     * Envia as credenciais do usuário para a API de autenticação.
     *
     * @param user objeto com email e senha enviados no formulário
     * @return token retornado pela API de autenticação
     */
    
    public AuthService() {
        this.restClient = RestClient.builder()
                // Define a base URL que será usada em todas as requisições.
                // Depois, cada chamada só precisa informar o caminho relativo.
                .baseUrl("http://localhost:8081")
                .build();
    }

    public String logar(UserRequestDTO user){
        
        // Faz chamada POST para o endpoint /auth/logar e retorna o corpo da resposta.
        return restClient.post()
                .uri("/api/auth/logar")
                .body(user)
                .retrieve()
                .body(String.class);
    }
    
    public void registrar(UserDTO user ) {
        user.setRole("FORNECEDOR");
        String retorno = 
            restClient
                .post()
                .uri("http://localhost:8081/api/autenticar/registrar")
                .body(user)
                .retrieve()
                .body(String.class);
    }
}
