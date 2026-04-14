package com.projeto.biblioteca.controller;

import com.projeto.biblioteca.database.model.AutorEntity;
import com.projeto.biblioteca.database.model.LivroEntity;
import com.projeto.biblioteca.dto.AutorDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/autores")
@RequiredArgsConstructor
@Validated
public class AutorController {


    private final AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAutores(@Valid @RequestBody AutorDTO autorDTO) throws BadRequestException {
        autorService.criarAutor(autorDTO);
    }

   @GetMapping("/{autorId}/obras")
   public List<LivroEntity> getLivros(@PathVariable Integer autorId){
        return autorService.getLivros(autorId);
    }

  @GetMapping
public List<AutorEntity> listarAutores(){
    return autorService.listarAutores();
}

@GetMapping("/{id}")
public AutorEntity buscarAutor(@PathVariable Integer id){
    return autorService.buscarAutor(id);
}

@DeleteMapping("/{id}")
public void deletarAutor(@PathVariable Integer id){
    autorService.deletarAutor(id);
}

    @PutMapping("/{id}")
    public void atualizarAutor(@PathVariable Integer id, AutorDTO autorDTO){
        autorService.atualizarAutor(id,autorDTO);
    }
}
