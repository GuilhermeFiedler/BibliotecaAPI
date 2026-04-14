package com.projeto.biblioteca.controller;

import com.projeto.biblioteca.database.model.ClienteEntity;
import com.projeto.biblioteca.dto.ClienteDTO;
import com.projeto.biblioteca.dto.ClienteUpdateDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
@Validated
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws BadRequestException {
        clienteService.criarCliente(clienteDTO);
    }
    @GetMapping
    public List<ClienteEntity> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteEntity buscarCliente(@PathVariable Integer id){
        return clienteService.buscarCliente(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Integer id){
        clienteService.deletarCliente(id);
    }

    @PatchMapping("/{id}")
    public void atualizarCliente(@PathVariable Integer id, @RequestBody ClienteUpdateDTO clienteUpdateDTO){
        clienteService.atualizarCliente(id,clienteUpdateDTO);
    }
}
