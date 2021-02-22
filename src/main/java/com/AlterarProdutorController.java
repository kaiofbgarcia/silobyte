/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Produtor;
import com.util.ArquivoProdutor;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author kaiof
 */
public class AlterarProdutorController {
    
    @FXML
    private TextField oldEmail;
    
    @FXML
    private TextField newNome;

    @FXML
    private TextField newCPF;

    @FXML
    private TextField newEmail;

    @FXML
    private void alterar() throws IOException{
        Produtor novoDado = new Produtor(newNome.getText(), newCPF.getText(), newEmail.getText());
        ArquivoProdutor.alterar(oldEmail.getText(), novoDado);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    void limpar(ActionEvent event) {
        newNome.setText("");
        newCPF.setText("");
        newEmail.setText("");
    }
    
    @FXML
    private void menu(ActionEvent even) throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void telaPrincipal(ActionEvent even) throws IOException{
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void sobre() throws IOException{
        App.setRoot("sobre");
    }
}
