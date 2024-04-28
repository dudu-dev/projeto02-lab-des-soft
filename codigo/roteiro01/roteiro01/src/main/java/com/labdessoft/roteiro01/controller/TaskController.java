package com.labdessoft.roteiro01.controller;

import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.service.TaskService;
import com.labdessoft.roteiro01.entity.TaskComDataEPrazo;

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


//Endipoins antigos que referenciam a tarefa do tipo livre
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
        

// Endpoints que referenciam novos tipos de tarefas com data e com prazo
    //@ApiOperation(value = "Retorna uma lista de tarefas com data e Prazo")
    //@GetMapping
    //public List<TaskComDataEPrazo> getTaskComDataEPrazo() {
    //    return taskService.searchTaskComDataEPrazo();
    //}

    //@ApiOperation(value = "Retorna uma tarefa especifica com data e Prazo")
    //@GetMapping("/{id}")
    //public Optional<TaskComDataEPrazo> getTaskComDataEPrazoById(@PathVariable Long id){
    //    return taskService.searchTaskComDataEPrazoById(id);
    //}

    @ApiOperation(value = "Recebe uma tarefa com data e Prazo")
    @PostMapping
    public ResponseEntity<TaskComDataEPrazo> postTaskComDataEPrazo(@RequestBody TaskComDataEPrazo reqBodyTask){
        TaskComDataEPrazo taskComDataEPrazo = TaskService.saveTaskComDataEPrazo(reqBodyTask);
        URI newTaskComDataEPrazoLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskComDataEPrazo.getId()).toUri();
        return ResponseEntity.created(newTaskComDataEPrazoLocation).body(taskComDataEPrazo);
    }

    @ApiOperation(value = "Recebe uma tarefa e varifica se é compativel com uma tarefa do tipo data e prazo")
    @PostMapping("/{id}")
    public ResponseEntity<TaskComDataEPrazo> postTaskComDataEPrazoById(@RequestBody TaskComDataEPrazo reqBodyTask){
        if(TaskComDataEPrazo.verificaSeDataEValidaParaIncluirTarefa(false)){
            TaskComDataEPrazo taskComDataEPrazo = TaskService.saveTaskComDataEPrazo(reqBodyTask);
            URI newTaskComDataEPrazoLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskComDataEPrazo.getId()).toUri();
            return ResponseEntity.created(newTaskComDataEPrazoLocation).body(taskComDataEPrazo);
        }
        else{
            return null;
        }
    }

    @ApiOperation(value = "Atualiza uma tarefa com data e Prazo")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putTaskComDataEPrazo(@PathVariable Long id, @RequestBody TaskComDataEPrazo reqBodyTask) {
        if (TaskComDataEPrazo.verificaSeDataEValidaParaIncluirTarefa(false)){
            reqBodyTask.setId(id);
            TaskService.saveTaskComDataEPrazo(reqBodyTask);
        }
    }
    
    @ApiOperation(value = "Exclui uma tarefa com data e Prazo")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskcomDataEPrazo(@PathVariable Long id){
    taskService.deleteTaskComDataEPrazoById(id);
    }
}