package com.projeto.biblioteca.database.repository;

import com.projeto.biblioteca.database.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAutorRepository extends JpaRepository<AutorEntity, Integer>
{
    Optional<AutorEntity> findByNomeIgnoreCase(String nome);


}