package com.labdessoft.roteiro01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class TaskComDataEPrazo extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataInicio")
    LocalDate dataInicio;

    @Column(name = "dataPrevista")
    LocalDate dataPrevista;
    
    @Column(name = "dataConclusao")
    LocalDate dataConclusao;  
    
    @Column(name = "statusDeAtraso")
    boolean statusEmAtraso;

    @Column(name = "quantidadeDiasEmAtraso")
    Long quantDias;

    @Column(name = "prazo")
    Long prazo;

    //A prioridade pode ser Alta, media e baixa
    @Column(name = "prioridade")
    String prioridade;

    public String convetePrioridadeAlta(Prioridade ALTA,  String prioridadeAlta){
        prioridadeAlta = Prioridade.ALTA.toString();
        return prioridadeAlta;
    }

    public String convertePrioridaeMedia(Prioridade MEDIA,  String prioridadeMedia){
        prioridadeMedia = Prioridade.MEDIA.toString();
        return prioridadeMedia;
    }

    public String convertePrioridaeBaixa(Prioridade BAIXA, String prioridadeBaixa){
        prioridadeBaixa = Prioridade.BAIXA.toString();
        return prioridadeBaixa;
    }

    public String definirPrioridade(String prioridadeAlta, String prioridadeMedia, String prioridadeBaixa){         
        if(prioridade.equals(prioridadeAlta)){
            prioridade = "alta";
        }
        else if(prioridade.equals(prioridadeMedia)){
            prioridade = "meida";
        }
        else if(prioridade.equals(prioridadeBaixa)){
            prioridade = "baixa";
        }    
        return prioridade;
    }
    
    public TaskComDataEPrazo(LocalDate dataInicio, LocalDate dataPrevista,LocalDate dataConclusao, boolean statusEmAtraso, Long quantDias, Long prazo, String prioridade){
        this.dataInicio = dataInicio;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
        this.statusEmAtraso = statusEmAtraso;
        this.prazo = prazo;
        this.prioridade = prioridade;
    }

    public Boolean VerificarDataEmAtraso(LocalDate dataPrevista, LocalDate dataConclusao, boolean statusDaTarefa){
        if (dataConclusao.isEqual(dataPrevista)) {
            statusEmAtraso = false;
        } 
        else if (dataConclusao.isAfter(dataPrevista)){
            statusEmAtraso = true;
        }
        return statusEmAtraso;
    }

    public Long QuantidadeDiasEmAtraso(LocalDate dataPrevista, LocalDate dataConclusao, Long quantDias){
        if (dataConclusao.getDayOfYear() >= dataPrevista.getDayOfYear()){
            quantDias = dataPrevista.until(dataConclusao, ChronoUnit.DAYS);
        }
        return quantDias;
    } 

    public Long DataCorridaEmdias(LocalDate dataInicio, LocalDate dataConclusao, Long prazo){
        if (dataConclusao.getDayOfYear() >= dataInicio.getDayOfYear()){
            prazo = dataInicio.until(dataConclusao, ChronoUnit.DAYS);            
        }
        return prazo;
    }

    public Boolean verificaSeDataEValidaParaIncluirTarefa(LocalDate dataConclusao, LocalDate dataAtual){
        dataAtual.getChronology();
        if(dataAtual.isEqual(dataConclusao) || dataAtual.isAfter(dataConclusao)){
            return true;
        }
        else{
            return false;
        }
    }

    public LocalDate getDataPrevista(){
        return dataPrevista;
    }
    @Override
    public void setDataPrevista(LocalDate dataPrevista){
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataConclusao(){
        return dataConclusao;
    }

    @Override
    public void setDataConclusao(LocalDate dataConclusao){
        this.dataConclusao = dataConclusao;
    }

    public static boolean verificaSeDataEValidaParaIncluirTarefa(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaSeDataEValidaParaIncluirTarefa'");
    }
}
