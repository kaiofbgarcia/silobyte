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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public static boolean excluir(long ID){
        ArrayList<Venda> lista = ArquivoVenda.listar();
        for(Venda u : lista){
            if(u.getID() == ID){
                ArrayList<Produtor> listaP = ArquivoProdutor.listar();
                for(Produtor p : listaP){   
                    if(p.getCPF().equals(u.getCpfProdutor())){
                        p.setDevendoMenos(u.getValorVenda());
                        ArquivoProdutor.alterar(u.getCpfProdutor(), p);
                    }
                }
                lista.remove(u);
                try {
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_VENDA);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(lista);
                    oos.close();
                    return true;
                } catch (IOException ex) {
                    System.out.println("Erro ao excluir venda!");
                    return false;
                }
            }
        }
        return false;
    }
    
    public static void alterar(long ID, LocalDate dataSaida){
        ArrayList<Venda> lista = ArquivoVenda.listar();
        for(Venda u : lista){   
            if(u.getID() == ID){  
                u.setDataSaida(dataSaida);
                long qtdDias = ChronoUnit.DAYS.between(u.getDataEntrada(), u.getDataSaida());
                if(u.getTipoGrao().equals("Milho")){
                    u.setValorVenda(u.getQtdSacas()* qtdDias * Venda.valorMilho);
                } else if(u.getTipoGrao().equals("Trigo")){
                    u.setValorVenda(u.getQtdSacas()* qtdDias * Venda.valorTrigo);
                } else if(u.getTipoGrao().equals("Soja")){
                    u.setValorVenda(u.getQtdSacas()* qtdDias * Venda.valorSoja);
                }
                ArrayList<Produtor> listaP = ArquivoProdutor.listar();
                for(Produtor p : listaP){   
                    if(p.getCPF().equals(u.getCpfProdutor())){
                        p.setDevendo(u.getValorVenda());
                        ArquivoProdutor.alterar(u.getCpfProdutor(), p);
                    }
                }
                try {
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_VENDA);
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