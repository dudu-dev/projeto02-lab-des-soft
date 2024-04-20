package com.labdessoft.roteiro01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.labdessoft.roteiro01.entity.Task;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private final ITaskJpaRepository taskJpaRepository;

    @Autowired
    public TaskRepository(ITaskJpaRepository taskJpaRepository){
        this.taskJpaRepository = taskJpaRepository;
    }

    public Task save(Task task){
        return taskJpaRepository.save(task);
    }

    public void deleteById(Long id){
        taskJpaRepository.deleteById(id);
    }

    public List<Task> search(){
        return taskJpaRepository.findAll();
    }

    public Optional<Task> seachById(Long id){
        return taskJpaRepository.findById(id);
    }

}
