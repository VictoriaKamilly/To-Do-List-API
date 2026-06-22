package com.example.To_Do.List.API.dto;

import com.example.To_Do.List.API.entity.Task;
import lombok.Getter;

@Getter
public class TaskResponseDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private Boolean concluida;

    private Long userId;

    public TaskResponseDTO(Task task) {

        this.id = task.getId();
        this.titulo = task.getTitulo();
        this.descricao = task.getDescricao();
        this.concluida = task.getConcluida();

        if (task.getUser() != null) {
            this.userId = task.getUser().getId();
        }
    }
}