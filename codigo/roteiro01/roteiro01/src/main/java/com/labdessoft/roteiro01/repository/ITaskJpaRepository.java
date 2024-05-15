package com.labdessoft.roteiro01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labdessoft.roteiro01.entity.Task;    

public interface ITaskJpaRepository  extends JpaRepository<Task, Long>{
    
    
}
