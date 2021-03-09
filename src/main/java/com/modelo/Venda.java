/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author kaiof
 */
public class Venda implements Serializable{
    public static final int valorMilho = 85;
    public static final int valorTrigo = 150;
    public static final int valorSoja = 160;
    
    String tipoGrao;
    String cpfProdutor;
    Usuario vendedor;
    int qtdSacas;
    LocalDate dataEntrada;
    LocalDate dataSaida;
    double valorVenda;
    long qtdDias;
    long ID;
  
    public Venda(String tipoGrao, String cpfProdutor, String qtdSacas, String dataEntrada, String dataSaida, long ID, Usuario vendedor){
        this.tipoGrao = tipoGrao;
        this.cpfProdutor = cpfProdutor;
        this.qtdSacas = Integer.parseInt(qtdSacas);
        this.ID = ID;
        this.vendedor = vendedor;
        this.dataEntrada = LocalDate.parse(dataEntrada);
        this.dataSaida = LocalDate.parse(dataSaida);
        this.qtdDias = ChronoUnit.DAYS.between(this.dataEntrada, this.dataSaida);
        if(this.tipoGrao.equals("Milho")){
            this.valorVenda = this.qtdSacas * this.qtdDias * Venda.valorMilho;
        } else if(this.tipoGrao.equals("Trigo")){
            this.valorVenda = this.qtdSacas*this.qtdDias*Venda.valorTrigo;
        } else if(tipoGrao.equals("Soja")){
            this.valorVenda = this.qtdSacas*this.qtdDias*Venda.valorSoja;
        }
    }
    

    public long getQtdDias(){
        return qtdDias;
    }
    
    public void setQtdDias(long qtdDias) {
        this.qtdDias = qtdDias;
    }
    
    public String getTipoGrao(){
        return tipoGrao;
    }
    
    public void setTipoGrao(String tipoGrao) {
        this.tipoGrao = tipoGrao;
    }
    
    public String getCpfProdutor(){
        return cpfProdutor;
    }
    
    public void setCpfProdutor(String cpfProdutor) {
        this.cpfProdutor = cpfProdutor;
    }
    
    public int getQtdSacas(){
        return qtdSacas;
    }
    
    public void setQtdSacas(int qtdSacas) {
        this.qtdSacas = qtdSacas;
    }
    
    public LocalDate getDataEntrada(){
        return dataEntrada;
    }
    
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    public LocalDate getDataSaida(){
        return dataSaida;
    }
    
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }   

    public double getValorVenda(){
        return valorVenda;
    }
    
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public long getID(){
        return ID;
    }
    
    public void setID(long ID) {
        this.ID = ID;
    }
    
    public String getVendedorNome(){
        return vendedor.getNome();
    }
//    public long getID(){
//        return ID;
//    }
//    
//    public void setID(long ID) {
//        this.ID = ID;
//    }
}