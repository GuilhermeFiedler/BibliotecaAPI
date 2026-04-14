package com.projeto.biblioteca.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteUpdateDTO {

    private String nome;

    private String cpf;
}
