/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Venda;
import com.util.ArquivoVenda;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 *
 * @author kaiof
 */
public class ListarVendaController {
    @FXML
    private TextArea campoLista;
    
    @FXML
    private void listar(ActionEvent even){
        ArrayList<Venda> lista = ArquivoVenda.listar();
        for(Venda u : lista){
            campoLista.appendText("Codigo da Venda: " + u.getID() + "\t\tVendedor:" + u.getVendedorNome() +"\t\tCPF do Produtor: " + u.getCpfProdutor() + "\n\t\t\tTipo do Grão: " + u.getTipoGrao() + "\n\t\t\tData de Entrada: " + u.getDataEntrada() + "\n\t\t\tData de Saída: " + u.getDataSaida() + "\n\t\t\tQuantidade de Sacas: " + u.getQtdSacas() + "\n\t\t\tValor da Venda: " + u.getValorVenda() +"\n\n");
        }
    }
    
    @FXML
    private void limparCampos(){
        this.campoLista.setText("");
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
