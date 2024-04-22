package com.labdessoft.roteiro01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;
import com.labdessoft.roteiro01.repository.TaskRepository;

@Service
public class TaskService {
    private static TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        TaskService.taskRepository = taskRepository;
    }

    public static TaskComDataEPrazo save(TaskComDataEPrazo task){
        return taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public List<TaskComDataEPrazo> search(){
        return taskRepository.search();
    }

    public Optional<TaskComDataEPrazo> searchById(Long id){
        return taskRepository.seachById(id);
    }
}