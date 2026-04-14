package com.projeto.biblioteca.database.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroEntity livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(nullable = false)
    private LocalDateTime dataPrevistaDevolucao;

    private LocalDateTime dataDevolucao;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
}
