package com.projeto.biblioteca.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "autores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<LivroEntity> livros;

}
