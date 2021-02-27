/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.modelo.Produtor;
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
public class ArquivoProdutor {
    public static void inserir(Produtor produtor){
        try {
            ArrayList<Produtor> atual = listar();
            atual.add(produtor);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_PRODUTOR);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Erro ao inserir usuário!");
        }
    }
    
    public static ArrayList<Produtor> listar() {
        ArrayList<Produtor> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_PRODUTOR);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Produtor>) ois.readObject();
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
    
    public static boolean excluir(Produtor produtor){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor u : lista){
            if(u.getNome().equals(produtor.getNome())){
                if(u.getCPF().equals(produtor.getCPF())){
                    if(u.getEmail().equals(produtor.getEmail())){
                        lista.remove(u);
                        try {
                            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_PRODUTOR);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(lista);
                            oos.close();
                            return true;
                        } catch (IOException ex) {
                            System.out.println("Erro ao excluir produtor!");
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void alterar(String CPF, Produtor produtorNovo){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor u : lista){   
            if(u.getCPF().equals(CPF)){  
                u.setNome(produtorNovo.getNome());
                u.setCPF(produtorNovo.getCPF());
                u.setEmail(produtorNovo.getEmail());
                u.setDevendo(produtorNovo.getDevendo());
                try {
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_PRODUTOR);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(lista);
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("Erro ao alterar produtor!");
                }
            }
        }
    }
}
