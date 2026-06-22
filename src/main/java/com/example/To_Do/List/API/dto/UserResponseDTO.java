package com.example.To_Do.List.API.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
}
