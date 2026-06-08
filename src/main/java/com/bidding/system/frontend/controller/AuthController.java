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

@Controller
public class AuthController {
    
    @Autowired
    private AuthService restService;
    
    @GetMapping("/index")
    public String home(HttpSession session) {
        return "index";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        UserRequestDTO credenciais = new UserRequestDTO();
        model.addAttribute("credenciais", credenciais);
        return "login";
    }
    
    @PostMapping("/logar")
    public String logar(@ModelAttribute UserRequestDTO credenciais, HttpSession session) {
        String token = restService.logar(credenciais);
        System.out.println("token: " + token);
        session.setAttribute("token", token);
        return "redirect:/index";
    }
    
    @GetMapping("/registrar")
    public String registrar(Model model) {
        UserDTO newUser = new UserDTO();
        model.addAttribute("user", newUser);
        return "registrar";
    }
    
    @PostMapping("/registrar")
    public String mandarRegistro(@ModelAttribute UserDTO user) {
        restService.registrar(user);
        return "redirect:/login";
    }
}