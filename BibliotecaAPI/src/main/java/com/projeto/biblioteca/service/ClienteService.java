package com.projeto.biblioteca.service;


import com.projeto.biblioteca.database.model.ClienteEntity;
import com.projeto.biblioteca.database.repository.IClienteRepository;
import com.projeto.biblioteca.database.repository.IEmprestimoRepository;
import com.projeto.biblioteca.dto.ClienteDTO;
import com.projeto.biblioteca.dto.ClienteUpdateDTO;
import com.projeto.biblioteca.exception.BadRequestException;
import com.projeto.biblioteca.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final IClienteRepository clienteRepository;
    private final IEmprestimoRepository emprestimoRepository;

    public void criarCliente(ClienteDTO clienteDTO) throws BadRequestException {
        if(clienteRepository.existsByCpf(clienteDTO.getCpf())){
            throw new BadRequestException("Cpf já cadastrado no sistema");
        }


        clienteRepository.save(ClienteEntity.builder()
                .nome(clienteDTO.getNome())
                .cpf(clienteDTO.getCpf())
                .build());
    }
    public List<ClienteEntity> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarCliente(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    public void deletarCliente(Integer id){
        ClienteEntity cliente = buscarCliente(id);

        boolean emprestimoFeito = emprestimoRepository.existsByClienteId(id);

        if (emprestimoFeito) {throw new BadRequestException("Não foi possível excluir o cliente. Cliente possui registros de uso da biblioteca.");
        }

        clienteRepository.delete(cliente);
    }

    @Transactional
    public void atualizarCliente(Integer id, ClienteUpdateDTO clienteUpdateDTO){
        ClienteEntity cliente = buscarCliente(id);

        if (clienteUpdateDTO.getCpf() != null) {
            boolean cpfExiste = clienteRepository.existsByCpfAndIdNot(clienteUpdateDTO.getCpf(), id);
            if (cpfExiste) {
                throw new BadRequestException("Cpf já cadastrado no sistema");
            }
            cliente.setCpf(clienteUpdateDTO.getCpf());
        }

        if (clienteUpdateDTO.getNome() != null) {
            cliente.setNome(clienteUpdateDTO.getNome());
        }
    }
}
