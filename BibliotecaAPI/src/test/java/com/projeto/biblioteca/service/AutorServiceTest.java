package com.projeto.biblioteca.service;

import com.projeto.biblioteca.database.model.AutorEntity;
import com.projeto.biblioteca.database.repository.IAutorRepository;
import com.projeto.biblioteca.dto.AutorDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

    @Mock // cria um repositório falso
    private IAutorRepository autorRepository;

    @InjectMocks // injeta ele dentro do service
    private AutorService autorService;


    @Test
    void deveCriarAutorQuandoNaoExistir() {

        AutorDTO dto = new AutorDTO();
        dto.setNome("Machado Assis");

        // Simula: não encontrou autor no banco
        when(autorRepository.findByNomeIgnoreCase("Machado Assis"))
                .thenReturn(Optional.empty());

        autorService.criarAutor(dto);

        verify(autorRepository).save(any(AutorEntity.class));
    }

    @Test
    void deveLancarExcecaoQuandoAutorJaExistir(){
        AutorDTO dto = new AutorDTO();
        dto.setNome("Machado Assis");

        AutorEntity autorExistente = AutorEntity.builder()
                .nome("Machado Assis")
                .build();

        when(autorRepository.findByNomeIgnoreCase("Machado Assis"))
                .thenReturn(Optional.of(autorExistente));

        assertThrows(BadRequestException.class, () -> {
            autorService.criarAutor(dto);
        });

        verify(autorRepository, never()).save(any());
    }


    @Test
    void deveListarAutores() {

        List<AutorEntity> lista = List.of(
                AutorEntity.builder().nome("Machado de Assis").build(),
                AutorEntity.builder().nome("Clarice Lispector").build()
        );

        when(autorRepository.findAll()).thenReturn(lista);

        List<AutorEntity> resultado = autorService.listarAutores();

        assertEquals(2, resultado.size());
        verify(autorRepository).findAll();
    }

    @Test
    void deveDeletarAutor(){

        AutorEntity autor = AutorEntity.builder()
                .id(1)
                .nome("Machado de Assis")
                .build();

        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));

        autorService.deletarAutor(1);

        verify(autorRepository).delete(autor);
    }


}