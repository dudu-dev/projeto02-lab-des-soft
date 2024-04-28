package com.labdessoft.roteiro01.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Todos os detalhes sobre uma tarefa. ")
@Table(name = "Tarefa livre")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "Status")
    private String status;

    @Column(name = "Descricao")
    private String description;

    @Column(name = "Individual")
    private boolean individual;

    @Column(name = "Equipe")
    private boolean team;

    @Column(name = "dataInicio")
    LocalDate dataInicio;

    @Column(name = "dataPrevista")
    LocalDate dataPrevista;
    
    @Column(name = "dataConclusao")
    LocalDate dataConclusao;  
    
    public Task(Long id, String name, String description, boolean individual, boolean team, LocalDate dataPrevista, LocalDate dataConclusao){
        this.id = id;
        this.name = name;
        this.description = description;
        this.individual = individual;
        this.team = team;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString(){
    return "Task [id]" + id + "[name]" + name + "[description]" + description + "[individual]" + individual + "[team]" + team;
    }
}