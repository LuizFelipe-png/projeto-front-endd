/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.controller;

import com.bidding.system.frontend.model.UserDTO;
import com.bidding.system.frontend.model.UserRequestDTO;
import com.bidding.system.frontend.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller responsável por atender às requisições de autenticação e páginas públicas.
 */
@Controller
public class AuthController {
    
    // Injeção do serviço de autenticação para delegar a lógica de login.    
    @Autowired
    private AuthService restService;
    
    // Tratador para requisições GET no caminho raiz "/".
    // Retorna o nome da view Thymeleaf "index".
    @GetMapping("/index")
    public String home(
            HttpSession session
    ) {
        return "index";
    }
    
    // Tratador para requisições GET em "/login".
    // Prepara o modelo com um objeto UserRequestDTO vazio para preencher o formulário.
    @GetMapping("/login")
    public String login(
        Model model
    ) {
        UserRequestDTO credenciais = new UserRequestDTO();
        model.addAttribute("credenciais", credenciais);
        return "login";
    }
    
    // Tratador para requisições POST em "/logar".
    // Recebe as credenciais submetidas pelo formulário e tenta autenticar.
    @PostMapping("/logar")
    public String logar(
            @ModelAttribute UserRequestDTO credenciais,
            HttpSession session
    ) {
        // Chama o serviço de autenticação para obter um token JWT ou similar.
        String token = restService.logar(credenciais);
        // Armazena o token na sessão HTTP para uso posterior.
        System.out.println("token: "+token);
        session.setAttribute("token", token);
        // Redireciona de volta para a página inicial após login bem sucedido.
        return "redirect:/";
    }
    
    @GetMapping("/registrar")
    public String registrar(
            Model model
    ) {
        UserDTO newUser = new UserDTO();
        model.addAttribute("user", newUser);
        return "registrar";
    }
    
    @PostMapping("/registrar")
    public String mandarRegistro(
            @ModelAttribute UserDTO user
    ) {
        restService.registrar(user);
        return "redirect:/login";
    }
}