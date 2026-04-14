package com.projeto.biblioteca.service;

import com.projeto.biblioteca.database.model.AutorEntity;
import com.projeto.biblioteca.database.model.LivroEntity;
import com.projeto.biblioteca.database.repository.IAutorRepository;
import com.projeto.biblioteca.dto.AutorDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final IAutorRepository autorRepository;

    public void criarAutor(AutorDTO autorDTO) throws BadRequestException {
        AutorEntity autor = autorRepository.findByNomeIgnoreCase(autorDTO.getNome())
                .orElse(null);

        if (autor != null){
            throw new BadRequestException("Autor já cadastrado no sistema");
        }

        autorRepository.save(AutorEntity.builder()
                .nome(autorDTO.getNome())
                .build());
    }

    public List<LivroEntity> getLivros(Integer autorId){
        AutorEntity autor = autorRepository.findById(autorId)
                .orElseThrow(()-> new NotFoundException("Autor não encontrado"));

        return autor.getLivros();
    }
    public List<AutorEntity> listarAutores(){
    return autorRepository.findAll();
}

public AutorEntity buscarAutor(Integer id){
    return autorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Autor não encontrado"));
}

public void deletarAutor(Integer id){
    AutorEntity autor = buscarAutor(id);
    try{
    autorRepository.delete(autor);} catch (DataIntegrityViolationException d) {
        throw new BadRequestException("Não foi possível excluir o autor, autor ainda possui vínculos com livros.");
    }
}
    @Transactional
    public void atualizarAutor(Integer id, AutorDTO autorDTO){
        AutorEntity autor = buscarAutor(id);

        autor.setNome(autorDTO.getNome());

    }
}
