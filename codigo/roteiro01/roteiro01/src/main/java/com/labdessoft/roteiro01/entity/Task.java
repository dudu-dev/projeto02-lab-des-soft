package com.labdessoft.roteiro01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    public Task(Long id, String name, String description, boolean individual, boolean team){
        this.id = id;
        this.name = name;
        this.description = description;
        this.individual = individual;
        this.team = team;
    }

    @Override
    public String toString(){
    return "Task [id]" + id + "[name]" + name + "[description]" + description + "[individual]" + individual + "[team]" + team;
    }
}