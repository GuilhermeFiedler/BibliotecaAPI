package com.projeto.biblioteca.database.repository;

import com.projeto.biblioteca.database.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILivroRepository extends JpaRepository<LivroEntity, Integer>
{
    Optional<LivroEntity> findByTitulo(String titulo);
}
