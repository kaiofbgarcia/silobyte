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
    private void excluirCadastro(ActionEvent even) throws IOException{
        Arquivo.excluir(logado);
        App.setRoot("menu");
    }
    
    @FXML
    private void cadastrarProdutor(ActionEvent even) throws IOException{
        App.setRoot("produtorCadastro");
    }
    
    @FXML
    private void listarProdutor(ActionEvent even) throws IOException{
        App.setRoot("listarProdutor");
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
