/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Produtor;
import com.util.ArquivoProdutor;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author kaiof
 */
public class PagamentoController {
    @FXML
    private TextField cpfProdutor;

    @FXML
    private TextField valorRecebido;

    @FXML
    private void pagar() throws IOException{
        double valor = Double.parseDouble(valorRecebido.getText());
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor u : lista){   
            if(u.getCPF().equals(cpfProdutor.getText())){
                u.setDevendoMenos(valor);
                ArquivoProdutor.alterar(cpfProdutor.getText(), u);
            }
        }
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void limparCampos(){
        this.cpfProdutor.setText("");
        this.valorRecebido.setText("");
    }
    
    @FXML
    private void voltar(ActionEvent even) throws IOException{
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
