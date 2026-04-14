package com.projeto.biblioteca.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class EmprestimoDTO {

    private Integer livroId;
    private Integer clienteId;

}
