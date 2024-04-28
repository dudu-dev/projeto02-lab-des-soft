package com.labdessoft.roteiro01.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.labdessoft.roteiro01.entity.Task;

@Repository
public class TaskRepository {
    public final ITaskjpaRepository taskRepository;

    @Autowired
    public TaskRepository(ITaskjpaRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(Long id){
        
        taskRepository.deleteById(id);
    }

    public List<Task> search(){
        return taskRepository.findAll();
    }

    public Optional<Task> seachById(Long id){
        return taskRepository.findById(id);
    }
}
