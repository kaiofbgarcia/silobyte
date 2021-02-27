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
    static int valorMilho = 85;
    static int valorTrigo = 150;
    static int valorSoja = 160;
    
    String tipoGrao;
    String cpfProdutor;
    int qtdSacas;
    LocalDate dataEntrada;
    LocalDate dataSaida;
    
    double valorVenda;
    long qtdDias;
 
    public Venda(){
        this.tipoGrao = "";
        this.cpfProdutor = "";
        this.qtdSacas = 0;
        this.dataEntrada = LocalDate.parse("0000-00-00");
        this.dataSaida= LocalDate.parse("0000-00-00");
        this.valorVenda = 0;
        this.qtdDias = 0;
    }
    public Venda(String tipoGrao, String cpfProdutor, String qtdSacas, String dataEntrada, String dataSaida){
        this.tipoGrao = tipoGrao;
        this.cpfProdutor = cpfProdutor;
        this.qtdSacas = Integer.parseInt(qtdSacas);
        this.dataEntrada = LocalDate.parse(dataEntrada);
        this.dataSaida = LocalDate.parse(dataSaida);
        this.qtdDias = ChronoUnit.DAYS.between(this.dataEntrada, this.dataSaida);
        if(this.tipoGrao.equals("Milho")){
            this.valorVenda = this.qtdSacas * this.qtdDias * this.valorMilho;
        } else if(this.tipoGrao.equals("Trigo")){
            this.valorVenda = this.qtdSacas*this.qtdDias*this.valorTrigo;
        } else if(tipoGrao.equals("Soja")){
            this.valorVenda = this.qtdSacas*this.qtdDias*this.valorSoja;
        }
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
}


//        if(tipoGrao.equals("Milho")){
//            valorVenda = qtdSacas*valorMilho;
//        } else if(tipoGrao.equals("Soja")){
//            valorVenda = qtdSacas*valorSoja;
//        } else if(tipoGrao.equals("Trigo")){
//            valorVenda = qtdSacas*valorTrigo;
//        }
//        produtor.devendo = valorVenda;