package com.projeto.biblioteca.database.repository;

import com.projeto.biblioteca.database.model.AutorEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class IAutorRepositoryTest {
    @Autowired
    IAutorRepository autorRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should return author ignoring case")
    void findByNomeIgnoreCase() {


        AutorEntity autor = AutorEntity.builder()
                .nome("Machado Assis")
                .build();

        entityManager.persist(autor);
        entityManager.flush();
        entityManager.clear();


        Optional<AutorEntity> result =
                autorRepository.findByNomeIgnoreCase("machado assis");

        assertThat(result).isPresent();
        assertThat(result.get().getNome()).isEqualTo("Machado Assis");
    }
}