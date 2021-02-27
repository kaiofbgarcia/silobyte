/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.modelo.Produtor;
import com.modelo.Venda;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author kaiof
 */
public class ArquivoVenda {
    public static void inserir(Venda venda){
        try {
            ArrayList<Venda> atual = listar();
            atual.add(venda);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_VENDA);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Erro ao inserir usuário!");
        }
    }
    
    public static ArrayList<Venda> listar() {
        ArrayList<Venda> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_VENDA);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Venda>) ois.readObject();
            ois.close();
            return lista;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (EOFException e) {  // arquivo vazio
            return lista;
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println("Erro ao ler arquivo!");
            }
        }
        return lista;
    }   
}