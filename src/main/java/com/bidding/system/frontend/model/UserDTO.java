/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.model;

/**
 *
 * @author Usuario
 */
// Classe de transferência de dados (Data Transfer Object) para usuários
// DTO é usado para transferir dados entre camadas da aplicação (Controller -> Service -> Repository)
public class UserDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String role;
    private String confirmarSenha;

    // Construtor vazio (padrão do JavaBeans)
    public UserDTO() {
    }

    public UserDTO(Long id, String nome, String email, String senha, String role, String confirmarSenha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.confirmarSenha = confirmarSenha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    
}