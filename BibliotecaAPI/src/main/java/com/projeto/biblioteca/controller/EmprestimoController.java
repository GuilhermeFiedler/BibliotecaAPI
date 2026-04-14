package com.projeto.biblioteca.controller;

import com.projeto.biblioteca.dto.EmprestimoDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/emprestimos")
@RequiredArgsConstructor
@Validated
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fazerEmprestimo(@Valid @RequestBody EmprestimoDTO emprestimoDTO) throws BadRequestException {
        emprestimoService.fazerEmprestimo(emprestimoDTO);
    }
@PutMapping("/{id}/devolver")
public void devolverLivro(@PathVariable Integer id){
    emprestimoService.devolverLivro(id);
}
}
