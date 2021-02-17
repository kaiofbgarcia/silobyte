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
public class AlterarCadastroController {
    
    
    @FXML
    private TextField newLogin;

    @FXML
    private TextField newNome;

    @FXML
    private TextField newSenha;
    
    @FXML
    private void alterar() throws IOException{
        Usuario novoDado = new Usuario(newLogin.getText(), newNome.getText(), newSenha.getText());
        Arquivo.alterar(TelaPrincipalController.logado, novoDado);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    void limpar(ActionEvent event) {
        newLogin.setText("");
        newNome.setText("");
        newSenha.setText("");
    }
    
    @FXML
    private void menu(ActionEvent even) throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void sobre() throws IOException{
        App.setRoot("sobre");
    }
}
