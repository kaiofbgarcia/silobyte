/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;

/**
 *
 * @author kaiof
 */
public class Usuario implements Serializable{
    String login;
    String nome;
    String senha;
    
    public Usuario(){
        this.login = "";
        this.nome = "";
        this.senha = "";
    }
    
    public Usuario(String login, String nome, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
