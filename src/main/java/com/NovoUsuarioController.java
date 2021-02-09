/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Usuario;
import com.util.Arquivo;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author kaiof
 */
public class NovoUsuarioController {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setNome(campoNome.getText());
        usuario.setSenha(campoSenha.getText());
        Arquivo.inserir(usuario);
    }
    
    @FXML
    private void limparCampos(){
        this.campoLogin.setText("");
        this.campoNome.setText("");
        this.campoSenha.setText("");
    }
    
    @FXML
    private void menu(ActionEvent even) throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void sair(ActionEvent even){
        System.exit(0);
    }
}
