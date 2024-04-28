package com.labdessoft.roteiro01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

public interface ITaskComDataEPrazojpaRepository extends JpaRepository<TaskComDataEPrazo, Long> {
    
    boolean existsById(Long id);

    boolean existsByName(String name);

    boolean existsByStatus(String status);

    boolean existsByDescription(String description);

    void deleteTaskComDataEPrazoaById(Long id);

    TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo);
}
