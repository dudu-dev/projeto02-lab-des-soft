package com.labdessoft.roteiro01.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labdessoft.roteiro01.entity.Task;    

public interface ITaskJpaRepository  extends JpaRepository<Task, Long>{
    
    boolean existsById();

    void deleteById(Long id);

    Task save(Task task);

    Optional<Task> findById(Long id);
    
}
