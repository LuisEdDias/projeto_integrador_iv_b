package com.luisdias.projeto_integrador_iv_b.api.model.services;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaFisica;
import com.luisdias.projeto_integrador_iv_b.api.dtos.clientepf.ClientePFGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe responsável por implementar as regras de negócio relacionadas à classe Cliente PF.
 */
@Service
public class ClientePFService implements com.luisdias.projeto_integrador_iv_b.api.controllers.clientepf.ClientePFService {
    // Declaração do atributo da interface com o repositório
    private final DatabaseRepository<ClientePessoaFisica, Long> clienteRepository;

    // Injeção da dependência da interface com o repositório via construtor
    public ClientePFService(DatabaseRepository<ClientePessoaFisica, Long> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClientePFGetDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClientePFGetDTO::new).toList();
    }

    @Override
    public ClientePFGetDTO getById(long id) {
        ClientePessoaFisica cliente = getCliente(id);
        return new ClientePFGetDTO(cliente);
    }

    @Override
    public ClientePFGetDTO create(PessoaCreateDTO createDTO) {
        ClientePessoaFisica cliente = new ClientePessoaFisica(createDTO);
        if(clienteRepository.exists(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        cliente = clienteRepository.insert(cliente)
                .orElseThrow(() -> new RuntimeException("Não foi possível realizar o cadastro."));
        return new ClientePFGetDTO(cliente);
    }

    @Override
    public ClientePFGetDTO update(long id, PessoaUpdateDTO updateDTO) {
        ClientePessoaFisica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateCliente(updateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePFGetDTO(cliente);
    }

    @Override
    public ClientePFGetDTO updateAddress(long id, EnderecoCreateDTO enderecoDTO) {
        ClientePessoaFisica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.newEndereco(enderecoDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePFGetDTO(cliente);
    }

    @Override
    public boolean delete(long id) {
        return clienteRepository.delete(id);
    }

    private ClientePessoaFisica getCliente(long id) {
        return clienteRepository.find(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
    }
}
