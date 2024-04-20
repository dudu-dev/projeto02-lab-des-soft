package com.labdessoft.roteiro01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Taskgenerica {
    
    Date data;
    Date prazo; 
    
    public Taskgenerica(Date data, Date prazo){
        this.data = data;
        this.prazo = prazo;
    }

}
