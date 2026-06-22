package com.example.To_Do.List.API.controller;

import com.example.To_Do.List.API.dto.UserResponseDTO;
import com.example.To_Do.List.API.entity.User;
import com.example.To_Do.List.API.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/listarUsuarios")
    public List<UserResponseDTO> listarUsuarios(){

        return service.listar()
                .stream()
                .map(user ->
                        new UserResponseDTO(
                                user.getId(),
                                user.getName(),
                                user.getEmail()
                        ))
                .toList();
    }

    @PostMapping("/criarUsuario")
    public User criarUsuario(
            @RequestBody User user
    ){
        return service.criar(user);
    }
}