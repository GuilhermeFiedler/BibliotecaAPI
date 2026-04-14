package com.projeto.biblioteca.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;
}
