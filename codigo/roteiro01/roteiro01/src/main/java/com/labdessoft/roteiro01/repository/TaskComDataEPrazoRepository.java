package com.labdessoft.roteiro01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskComDataEPrazoRepository {

    private final ITaskJpaRepository taskJpaRepository;

    @Autowired
    public TaskComDataEPrazoRepository(ITaskJpaRepository taskJpaRepository){
        this.taskJpaRepository = taskJpaRepository;
    }

    public TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo2){
        return taskJpaRepository.saveTaskComDataEPrazo(taskComDataEPrazo2);
    }

    public void deleteTaskComDataEPrazoById(Long id){
        taskJpaRepository.deleteTaskComDataEPrazoById(id);
    }

    //public List<TaskComDataEPrazo> searchTaskComDataEPrazo(){
    //    return taskJpaRepository.findAll();
    //}

    //public Optional<TaskComDataEPrazo> seachTaskComDataEPrazoById(Long id){
    //    return taskJpaRepository.findById(id);
    //}

    public Task save(Task task){
        return taskJpaRepository.save(task);
    }

    public void deleteById(Long id){
        
        taskJpaRepository.deleteById(id);
    }

    public List<Task> search() {
        return taskJpaRepository.findAll();
    }

    public Optional<Task> seachById(Long id){
        return taskJpaRepository.findById(id);
    }  
}
