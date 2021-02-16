/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.TelaPrincipalController.logado;
import com.modelo.Usuario;
import com.util.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author kaiof
 */
public class MenuController {
    @FXML
    private Text erroLogin;
            
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private void cadastrarUsuario() throws IOException{
        App.setRoot("novoUsuario");
    }
    
    @FXML
    private void listarUsuarios() throws IOException{
        App.setRoot("listarUsuario");
    }
    
    @FXML
    private void entrar() throws IOException{
        ArrayList<Usuario> lista = Arquivo.listar();
        for(Usuario u : lista){
            if(u.getLogin().equals(campoLogin.getText())){
                if(u.getSenha().equals(campoSenha.getText())){
                    TelaPrincipalController.logado = u;
                    App.setRoot("telaPrincipal");
                }
            } else{
                erroLogin.setText("Login ou Senha Incorretos");
            }
        }
    }
    
    @FXML
    private void sobre() throws IOException{
        App.setRoot("sobre");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
}
