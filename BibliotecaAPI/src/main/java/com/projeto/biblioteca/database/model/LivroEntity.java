package com.projeto.biblioteca.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnore
    private AutorEntity autor;

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private Set<EmprestimoEntity> reservas = new HashSet<>();
}
