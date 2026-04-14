package com.projeto.biblioteca.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LivroDTO {

    @NotNull
    private Integer autorId;
    @NotBlank
    private String titulo;
}
