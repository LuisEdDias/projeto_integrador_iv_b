package com.luisdias.projeto_integrador_iv_b.api.model.services;

import com.luisdias.projeto_integrador_iv_b.api.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaJuridica;
import com.luisdias.projeto_integrador_iv_b.api.dtos.clientepj.ClientePJGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe responsável por implementar as regras de negócio relacionadas à classe Cliente PJ.
 */
@Service
public class ClientePJService implements com.luisdias.projeto_integrador_iv_b.api.controllers.clientepj.ClientePJService {
    // Declaração do atributo da interface com o repositório
    private final DatabaseRepository<ClientePessoaJuridica, String> clienteRepository;

    // Injeção da dependência da interface com o repositório via construtor
    public ClientePJService(DatabaseRepository<ClientePessoaJuridica, String> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClientePJGetDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClientePJGetDTO::new).toList();
    }

    @Override
    public ClientePJGetDTO getById(String id) {
        ClientePessoaJuridica cliente = getCliente(id);
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public ClientePJGetDTO create(EmpresaCreateDTO createDTO) {
        ClientePessoaJuridica cliente = new ClientePessoaJuridica(createDTO);
        if(clienteRepository.exists(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        cliente = clienteRepository.insert(cliente)
                .orElseThrow(() -> new RuntimeException("Não foi possível realizar o cadastro."));
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public ClientePJGetDTO updateEndereco(String id, EnderecoCreateDTO enderecoDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEndereco(enderecoDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public ClientePJGetDTO updateEnderecoProprietario(String id, EnderecoCreateDTO enderecoCreateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEnderecoProprietario(enderecoCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public ClientePJGetDTO updateDadosProprietario(String id, PessoaUpdateDTO updateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateDadosProprietario(updateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public ClientePJGetDTO newProprietario(String id, PessoaCreateDTO createDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.newProprietario(createDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    @Override
    public boolean delete(String id) {
        return clienteRepository.delete(id);
    }

    private ClientePessoaJuridica getCliente(String id) {
        return clienteRepository.find(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
    }
}
