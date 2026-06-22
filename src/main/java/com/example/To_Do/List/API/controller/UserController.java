package com.example.To_Do.List.API.controller;

import com.example.To_Do.List.API.entity.User;
import com.example.To_Do.List.API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.To_Do.List.API.dto.UserResponseDTO;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/listarUsuarios")
    public List<UserResponseDTO> listarUsuarios(){

        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }


    @PostMapping("/criarUsuario")
    public User criarUsuario(@RequestBody User user){
        return repository.save(user);
    }

}
