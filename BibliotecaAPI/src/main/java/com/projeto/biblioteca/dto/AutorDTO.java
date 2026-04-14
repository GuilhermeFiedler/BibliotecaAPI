package com.projeto.biblioteca.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AutorDTO {

    private Integer autorId;
    @NotBlank
    private String nome;
}
