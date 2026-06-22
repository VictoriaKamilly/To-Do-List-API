package com.example.To_Do.List.API.controller;

import com.example.To_Do.List.API.entity.Task;
import com.example.To_Do.List.API.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Task criar(
            @PathVariable Long userId,
            @RequestBody Task task
    ) {
        return service.criar(task, userId);
    }

    @GetMapping("/{userId}")
    public List<Task> listar(
            @PathVariable Long userId
    ) {
        return service.listar(userId);
    }

    @PutMapping("/{id}")
    public Task atualizar(
            @PathVariable Long id,
            @RequestBody Task task
    ) {
        return service.atualizar(id, task);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @PatchMapping("/{id}/concluir")
    public Task concluir(
            @PathVariable Long id
    ) {
        return service.concluir(id);
    }
}