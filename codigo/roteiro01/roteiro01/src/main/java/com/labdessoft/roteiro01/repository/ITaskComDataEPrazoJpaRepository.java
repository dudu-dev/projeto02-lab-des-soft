package com.labdessoft.roteiro01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

public interface ITaskComDataEPrazoJpaRepository extends JpaRepository<TaskComDataEPrazo, Long>{


    Optional<TaskComDataEPrazo> findById(Long id);

    void deleteById(Long id);
    
}
