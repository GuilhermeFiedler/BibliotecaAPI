package com.projeto.biblioteca.service;

import com.projeto.biblioteca.database.model.AutorEntity;
import com.projeto.biblioteca.database.model.LivroEntity;
import com.projeto.biblioteca.database.repository.IAutorRepository;
import com.projeto.biblioteca.database.repository.ILivroRepository;
import com.projeto.biblioteca.dto.LivroDTO;
import com.projeto.biblioteca.dto.LivroUpdateDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LivroService {

    private final ILivroRepository livroRepository;
    private final IAutorRepository autorRepository;

    public void criarLivro(LivroDTO livroDTO) {
        LivroEntity livro = livroRepository.findByTitulo(livroDTO.getTitulo())
                .orElse(null);

        AutorEntity autor = autorRepository.findById(livroDTO.getAutorId())
                .orElseThrow(() -> new BadRequestException("Autor não encontrado"));

        if (livro != null) {
            throw new BadRequestException("Livro já cadastrado no sistema");
        }

        livroRepository.save(LivroEntity.builder()
                .autor(autor)
                .titulo(livroDTO.getTitulo())
                .build());
    }

    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroEntity buscarLivro(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
    }

    @Transactional
    public void atualizarLivro(Integer id, LivroUpdateDTO livroUpdateDTO) {
        LivroEntity livro = buscarLivro(id);

        if (livroUpdateDTO.getTitulo() != null) {
            livro.setTitulo(livroUpdateDTO.getTitulo());
        }

        if (livroUpdateDTO.getAutorId() != null) {
            AutorEntity autor = autorRepository.findById(livroUpdateDTO.getAutorId())
                    .orElseThrow(() -> new BadRequestException("Autor não encontrado"));

            livro.setAutor(autor);
        }
    }
}