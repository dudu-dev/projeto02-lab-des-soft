package com.labdessoft.roteiro01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

public interface ITaskJpaRepository  extends JpaRepository<Task, Long>{
    
    boolean existById();

    Task save(Task task);

    void deleteById(Long id);

    Optional<Task> findById(Long id);

	TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo2);

    void deleteTaskComDataEPrazoById(Long id);
    
}
