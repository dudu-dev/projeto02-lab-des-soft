package com.labdessoft.roteiro01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;


@Repository
public class TaskRepository {

    private final ITaskJpaRepository taskJpaRepository;
    private final ITaskComDataEPrazoJpaRepository taskComDataEPrazoJpaRepository;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TarefasPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Autowired
    public TaskRepository(ITaskJpaRepository taskJpaRepository, ITaskComDataEPrazoJpaRepository taskComDataEPrazoJpaRepository){
        this.taskJpaRepository = taskJpaRepository;
        this.taskComDataEPrazoJpaRepository = taskComDataEPrazoJpaRepository;
    }

    public TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo2){
        return taskComDataEPrazoJpaRepository.save(taskComDataEPrazo2);
    }

    public void deleteTaskComDataEPrazoById(Long id){
        taskComDataEPrazoJpaRepository.deleteById(id);
    }

    public List<TaskComDataEPrazo> searchTaskComDataEPrazo(){
        return taskComDataEPrazoJpaRepository.findAll();
    }

    public Optional<TaskComDataEPrazo> seachTaskComDataEPrazoById(Long id){
        return taskComDataEPrazoJpaRepository.findById(id);
    }

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
