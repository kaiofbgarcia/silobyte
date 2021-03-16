/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Produtor;
import com.modelo.Venda;
import com.util.ArquivoProdutor;
import com.util.ArquivoVenda;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 *
 * @author kaiof
 */
public class VendaController {
    
    
    @FXML
    private MenuButton campoGrao;

    @FXML
    private TextField cpfProdutor;
    
    @FXML
    private TextField campoID;

    @FXML
    private TextField qtdSacas;

    @FXML
    private TextField dataEntrada;

    @FXML
    private TextField dataSaida;
    

    
    @FXML
    private void defineMilho(ActionEvent even) {
        campoGrao.setText("Milho");
    }
    @FXML
    private void defineTrigo(ActionEvent even) {
        campoGrao.setText("Trigo");
    }
    @FXML
    private void defineSoja(ActionEvent even) {
        campoGrao.setText("Soja");
    }
    
    @FXML
    private long verificaID(){
        ArrayList<Venda> lista = ArquivoVenda.listar();
        long id = 0;
        
        if(lista.isEmpty()){
            return 1;
        }else{
            for(Venda u : lista){
                id = u.getID();
            }
            
            return id+1;
        }   
    }
    
    @FXML
    private void vender(ActionEvent even) throws IOException{
 
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        Venda venda = new Venda(campoGrao.getText(), cpfProdutor.getText(), qtdSacas.getText(), dataEntrada.getText(), dataSaida.getText() , TelaPrincipalController.logado);
        venda.setID(verificaID());
        for(Produtor u : lista){   
            if(u.getCPF().equals(cpfProdutor.getText())){
                u.setDevendoMais(venda.getValorVenda());
                ArquivoProdutor.alterar(cpfProdutor.getText(), u);
            }
        }
        ArquivoVenda.inserir(venda);
        App.setRoot("telaPrincipal");
    }
    
    @FXML
    private void limparCampos(){
        campoGrao.setText("");
        cpfProdutor.setText("");
        qtdSacas.setText("");
        dataEntrada.setText("");
        dataSaida.setText("");
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
