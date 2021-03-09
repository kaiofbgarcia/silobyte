/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.util.ArquivoVenda;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author kaiof
 */
public class AlterarVendaController {
    
    @FXML
    private TextField campoID;
    
    @FXML
    private TextField campoData;
    
    @FXML
    private void alterarVenda(ActionEvent even) throws IOException{
        long id = Long.valueOf(campoID.getText());
        LocalDate data = LocalDate.parse(campoData.getText());
        ArquivoVenda.alterar(id,  data);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void limparCampos(){
        this.campoID.setText("");
        this.campoData.setText("");
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
    
    @FXML
    private void sair(ActionEvent even){
        System.exit(0);
    } 
}
