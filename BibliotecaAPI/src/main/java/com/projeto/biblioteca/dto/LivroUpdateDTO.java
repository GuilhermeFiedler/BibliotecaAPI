package com.projeto.biblioteca.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LivroUpdateDTO {

    private Integer autorId;

    private String titulo;
}
