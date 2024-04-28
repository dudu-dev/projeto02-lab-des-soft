package com.labdessoft.roteiro01.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;
import com.labdessoft.roteiro01.repository.TaskComDataEPrazoRepository;
import com.labdessoft.roteiro01.repository.TaskRepository;

@Service
public class TaskService {
    private static TaskComDataEPrazoRepository taskComDataEPrazoRepository;
    private static TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository ,TaskComDataEPrazoRepository taskComDataEPrazoRepository){
        TaskService.taskComDataEPrazoRepository = taskComDataEPrazoRepository;
    }
    public static Task save(Task task){
        return taskRepository.save(task);
    }
    
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
    
    public List<Task> search(){
        return taskRepository.search();
    }

    public Optional<Task> searchById(Long id){
        return taskRepository.seachById(id);
    }
    
    public static TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo){
        return taskComDataEPrazoRepository.saveTaskComDataEPrazo(taskComDataEPrazo);
    }

    public void deleteTaskComDataEPrazoById(Long id){
        taskComDataEPrazoRepository.deleteTaskComDataEPrazoById(id);
    }

    public List<TaskComDataEPrazo> searchTaskComDataEPrazo(){
        return taskComDataEPrazoRepository.searchTaskComDataEPrazo();
    }
    
    public Optional<TaskComDataEPrazo> searchTaskComDataEPrazoById(Long id){
        return taskComDataEPrazoRepository.seachTaskComDataEPrazoById(id);
    }
}