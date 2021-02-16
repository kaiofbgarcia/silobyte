/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.modelo.Usuario;
import com.util.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 *
 * @author kaiof
 */
public class ListarUsuarioController {
    @FXML
    private TextArea campoLista;
    
    @FXML
    private void listar(ActionEvent even){
        ArrayList<Usuario> lista = Arquivo.listar();
        for(Usuario u : lista){
            campoLista.appendText("Nome:" + u.getNome() + "\n");
        }
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
