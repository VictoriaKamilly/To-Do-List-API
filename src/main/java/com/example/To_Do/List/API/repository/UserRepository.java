package com.example.To_Do.List.API.repository;

import com.example.To_Do.List.API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}