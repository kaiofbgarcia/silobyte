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
public class ExcluirProdutorController {
    
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoEmail;

    public static Produtor logadoP = new Produtor();
    
    @FXML
    private void excluirProdutor() throws IOException{
        logadoP.setNome(campoNome.getText());
        logadoP.setCPF(campoCPF.getText());
        logadoP.setEmail(campoEmail.getText());
        ArquivoProdutor.excluir(logadoP);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void limparCampos(){
        this.campoNome.setText("");
        this.campoCPF.setText("");
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
    
    @FXML
    private void sair(ActionEvent even){
        System.exit(0);
    }
}
