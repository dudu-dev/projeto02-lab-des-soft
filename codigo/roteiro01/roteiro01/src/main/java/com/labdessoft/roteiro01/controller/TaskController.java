package com.labdessoft.roteiro01.controller;

import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.service.TaskService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @ApiOperation(value = "Retorna uma lista de tarefas")
    @GetMapping
    public List<Task> getTask() {
        return taskService.search();
    }

    @ApiOperation(value = "Retorna uma tarefa especifica")
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.searchById(id); 
    }

    @ApiOperation(value = "Recebe uma tarefa")
    @PostMapping
    public ResponseEntity <Task> postTask(@RequestBody Task reqBodyTask){
        Task task = TaskService.save(reqBodyTask);
        URI newTaskLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(newTaskLocation).body(task);
    }

    @ApiOperation(value = "Atualiza uma tarefa")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putTask(@PathVariable Long id, @RequestBody Task reqBodyTask) {
        reqBodyTask.setId(id);
        TaskService.save(reqBodyTask);
    }

    @ApiOperation(value = "Exclui uma tarefa")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
    }    
}
