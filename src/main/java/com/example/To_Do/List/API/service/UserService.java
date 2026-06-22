package com.example.To_Do.List.API.service;

import com.example.To_Do.List.API.entity.User;
import com.example.To_Do.List.API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Criar
    public User criar(User user){

        if(repository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }

        return repository.save(user);
    }

    // Listar
    public List<User> listar(){
        return repository.findAll();
    }

    // Buscar por id
    public User buscarPorId(Long id){

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));
    }

    // Atualizar
    public User atualizar(Long id, User dados){

        User user = buscarPorId(id);

        user.setName(dados.getName());
        user.setEmail(dados.getEmail());
        user.setPassword(dados.getPassword());

        return repository.save(user);
    }

    // Deletar
    public void deletar(Long id){

        User user = buscarPorId(id);

        repository.delete(user);
    }
}