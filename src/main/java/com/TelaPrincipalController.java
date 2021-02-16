/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Usuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author kaiof
 */
public class TelaPrincipalController {
    
    public static Usuario logado = new Usuario();
    
    @FXML
    private void alterarCadastro(ActionEvent even) throws IOException{
        App.setRoot("alterarCadastro");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
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
