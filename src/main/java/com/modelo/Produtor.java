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
public class Produtor implements Serializable{
    String nome;
    String cpf;
    String email;
    double devendo;
    
    public Produtor(){
        this.cpf = "";
        this.nome = "";
        this.email = "";
        this.devendo = 0;
    }
    
    public Produtor(String nome, String cpf, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    
    public String getCPF(){
        return cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
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
    
    public double getDevendo(){
        return devendo;
    }
    public void setDevendo(double devendo) {
        this.devendo = devendo;
    }
    public void setDevendoMais(double devendo) {
        this.devendo = this.devendo + devendo;
    }
    public void setDevendoMenos(double devendo) {
        this.devendo = this.devendo - devendo;
    }
}
