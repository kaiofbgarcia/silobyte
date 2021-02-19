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
public class ProdutorCadastroController {
    @FXML
    private TextField produtorNome;

    @FXML
    private TextField produtorCPF;
    
    @FXML
    private TextField produtorEmail;
    
    @FXML
    private void limparCampos(){
        this.produtorNome.setText("");
        this.produtorCPF.setText("");
        this.produtorEmail.setText("");
    }
    
    @FXML
    private void cadastrarProdutor() throws IOException{
        Produtor produtor = new Produtor();
        produtor.setNome(produtorNome.getText());
        produtor.setCPF(produtorCPF.getText());
        produtor.setEmail(produtorEmail.getText());
        ArquivoProdutor.inserir(produtor);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    private void telaPrincipal(ActionEvent even) throws IOException{
        App.setRoot("telaPrincipal");
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

