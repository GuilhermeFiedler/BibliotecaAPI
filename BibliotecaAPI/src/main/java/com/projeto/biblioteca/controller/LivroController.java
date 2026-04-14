package com.projeto.biblioteca.controller;

import com.projeto.biblioteca.database.model.LivroEntity;
import com.projeto.biblioteca.dto.LivroDTO;
import com.projeto.biblioteca.dto.LivroUpdateDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/acervo")
@RequiredArgsConstructor
@Validated
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarLivro(@Valid @RequestBody LivroDTO livroDTO) throws BadRequestException {
       livroService.criarLivro(livroDTO);
    }
    @GetMapping
public List<LivroEntity> listarLivros(){
    return livroService.listarLivros();
}

@GetMapping("/{id}")
public LivroEntity buscarLivro(@PathVariable Integer id){
    return livroService.buscarLivro(id);
}

    @PatchMapping("/{id}")
    public void atualizarLivro(@PathVariable Integer id, @RequestBody LivroUpdateDTO livroUpdateDTO){
        livroService.atualizarLivro(id,livroUpdateDTO);
    }
}
