package com.projeto.biblioteca.service;

import com.projeto.biblioteca.database.model.ClienteEntity;
import com.projeto.biblioteca.database.model.EmprestimoEntity;
import com.projeto.biblioteca.database.model.LivroEntity;
import com.projeto.biblioteca.database.model.StatusEmprestimo;
import com.projeto.biblioteca.database.repository.IClienteRepository;
import com.projeto.biblioteca.database.repository.IEmprestimoRepository;
import com.projeto.biblioteca.database.repository.ILivroRepository;
import com.projeto.biblioteca.dto.EmprestimoDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final IEmprestimoRepository emprestimoRepository;
    private final ILivroRepository livroRepository;
    private final IClienteRepository clienteRepository;

    public void fazerEmprestimo(EmprestimoDTO emprestimoDTO){

        LivroEntity livro = livroRepository.findById(emprestimoDTO.getLivroId())
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));

        ClienteEntity cliente = clienteRepository.findById(emprestimoDTO.getClienteId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        boolean livroEmprestado = emprestimoRepository
        .existsByLivroIdAndStatus(
                emprestimoDTO.getLivroId(),
                StatusEmprestimo.ATIVO
        );

if(livroEmprestado){
    throw new BadRequestException("Livro já está emprestado");
}
LocalDateTime agora = LocalDateTime.now();

        emprestimoRepository.save(EmprestimoEntity.builder()
                .livro(livro)
                .cliente(cliente)
                .dataEmprestimo(agora)
                .dataPrevistaDevolucao(agora.plusDays(7))
                .status(StatusEmprestimo.ATIVO)
                .build());

        
    }

    public void devolverLivro(Integer id){

    EmprestimoEntity emprestimo = emprestimoRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Empréstimo não encontrado"));

        if (emprestimo.getStatus() == StatusEmprestimo.DEVOLVIDO) {
            throw new BadRequestException("Empréstimo já foi finalizado");
        }

    emprestimo.setDataDevolucao(LocalDateTime.now());
    emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);

    emprestimoRepository.save(emprestimo);
}
}
