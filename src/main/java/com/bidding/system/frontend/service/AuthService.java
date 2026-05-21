/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.service;

import com.bidding.system.frontend.model.UserRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço responsável por comunicação com a API de autenticação externa.
 */
@Service
public class AuthService {
    // Cliente HTTP usado para fazer chamadas REST para a API externa.
    private RestTemplate restTemplate = new RestTemplate();
    // URL base da API de backend onde a autenticação é realizada.
    private final String BASE_URL = "http://localhost:3333/api";
    
    /**
     * Envia as credenciais do usuário para a API de autenticação.
     *
     * @param user objeto com email e senha enviados no formulário
     * @return token retornado pela API de autenticação
     */
    public String logar(UserRequestDTO user) {
        // Cria o corpo da requisição HTTP contendo o objeto UserRequestDTO.
        HttpEntity<UserRequestDTO> body = new HttpEntity(
                user);
        
        // Faz chamada POST para o endpoint /auth/logar e retorna o corpo da resposta.
        return restTemplate.exchange(
                BASE_URL + "/auth/logar",
                HttpMethod.POST,
                body,
                String.class
                ).getBody();
       
    }
}
