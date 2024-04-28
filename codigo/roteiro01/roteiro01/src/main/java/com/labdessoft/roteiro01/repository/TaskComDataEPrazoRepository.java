package com.labdessoft.roteiro01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskComDataEPrazoRepository {

    private final ITaskComDataEPrazojpaRepository taskComDataEPrazojpaRepository;

    @Autowired
    public TaskComDataEPrazoRepository(ITaskComDataEPrazojpaRepository taskComDataEPrazojpaRepository){
        this.taskComDataEPrazojpaRepository = taskComDataEPrazojpaRepository;
    }

    public TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo){
        return taskComDataEPrazojpaRepository.saveTaskComDataEPrazo(taskComDataEPrazo);
    }

    public void deleteTaskComDataEPrazoById(Long id){
        taskComDataEPrazojpaRepository.deleteTaskComDataEPrazoaById(id);
    }

    public List<TaskComDataEPrazo> searchTaskComDataEPrazo(){
        return taskComDataEPrazojpaRepository.findAll();
    }

    public Optional<TaskComDataEPrazo> seachTaskComDataEPrazoById(Long id){
        return taskComDataEPrazojpaRepository.findById(id);
    }
}
