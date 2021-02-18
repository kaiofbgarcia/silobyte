/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.modelo.Usuario;
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
public class Arquivo {
    
    public static void inserir(Usuario usuario){
        try {
            ArrayList<Usuario> atual = listar();
            atual.add(usuario);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_USUARIO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Erro ao inserir usuário!");
        }
    }
    
    public static ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_USUARIO);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Usuario>) ois.readObject();
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
    
    public static void excluir(Usuario usuario){
        ArrayList<Usuario> lista = Arquivo.listar();
        for(Usuario u : lista){
            if(u.getLogin().equals(usuario.getLogin())){
                if(u.getSenha().equals(usuario.getSenha())){
                    lista.remove(u);
                    try {
                        FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_USUARIO);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(lista);
                        oos.close();
                    } catch (IOException ex) {
                        System.out.println("Erro ao excluir usuário!");
                    }
                }
            }
        }
    }
    
    public static void alterar(Usuario usuarioBusca, Usuario usuarioNovo){
        ArrayList<Usuario> lista = Arquivo.listar();
        for(Usuario u : lista){
            if(u.getLogin().equals(usuarioBusca.getLogin())){
                if(u.getSenha().equals(usuarioBusca.getSenha())){
                    u.setLogin(usuarioNovo.getLogin());
                    u.setNome(usuarioNovo.getNome());
                    u.setSenha(usuarioNovo.getSenha());
                    try {
                        FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_USUARIO);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(lista);
                        oos.close();
                    } catch (IOException ex) {
                        System.out.println("Erro ao alterar usuário!");
                    }
                }
            }
        }
    }
}
