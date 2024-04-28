package com.labdessoft.roteiro01.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;
import com.labdessoft.roteiro01.repository.TaskComDataEPrazoRepository;

@Service
public class TaskService {
    private static TaskComDataEPrazoRepository taskComDataEPrazoRepository;

    @Autowired
    public TaskService(TaskComDataEPrazoRepository taskComDataEPrazoRepository){
        TaskService.taskComDataEPrazoRepository = taskComDataEPrazoRepository;
    }
    public static Task save(Task task){
        return taskComDataEPrazoRepository.save(task);
    }
    
    public void deleteById(Long id){
        taskComDataEPrazoRepository.deleteById(id);
    }

    public List<Task> search() {
        return taskComDataEPrazoRepository.search();
    }

    public Optional<Task> searchById(Long id){
        return taskComDataEPrazoRepository.seachById(id);
    }
    
    public static TaskComDataEPrazo saveTaskComDataEPrazo(TaskComDataEPrazo taskComDataEPrazo){
        return taskComDataEPrazoRepository.saveTaskComDataEPrazo(taskComDataEPrazo);
    }

    public void deleteTaskComDataEPrazoById(Long id){
        taskComDataEPrazoRepository.deleteTaskComDataEPrazoById(id);
    }

    //public List<TaskComDataEPrazo> searchTaskComDataEPrazo(){
    //    return taskComDataEPrazoRepository.searchTaskComDataEPrazo();
    //}
    
    //public Optional<TaskComDataEPrazo> searchTaskComDataEPrazoById(Long id){
    //    return taskComDataEPrazoRepository.seachTaskComDataEPrazoById(id);
    //}
    
}