package com.projeto.biblioteca.database.repository;

import com.projeto.biblioteca.database.model.EmprestimoEntity;
import com.projeto.biblioteca.database.model.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmprestimoRepository  extends JpaRepository<EmprestimoEntity, Integer> {

    boolean existsByLivroIdAndStatus(Integer livroId, StatusEmprestimo status);

    boolean existsByClienteId(Integer clienteId);


}
