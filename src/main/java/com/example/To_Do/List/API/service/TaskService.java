package com.example.To_Do.List.API.service;

import com.example.To_Do.List.API.entity.Task;
import com.example.To_Do.List.API.entity.User;
import com.example.To_Do.List.API.repository.TaskRepository;
import com.example.To_Do.List.API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(
            TaskRepository taskRepository,
            UserRepository userRepository
    ) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task criar(Task task, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<Task> listar(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task atualizar(Long id, Task dados) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setTitulo(dados.getTitulo());
        task.setDescricao(dados.getDescricao());
        task.setConcluida(dados.getConcluida());

        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        taskRepository.deleteById(id);
    }

    public Task concluir(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setConcluida(true);

        return taskRepository.save(task);
    }
}