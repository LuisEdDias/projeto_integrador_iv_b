package com.luisdias.projeto_integrador_iv_b.services;

import com.luisdias.projeto_integrador_iv_b.dtos.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.repositories.ClienteRepositoryInterface;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// Classe responsável por implementar as regras de negócio relacionadas à classe Cliente
@Service
public class ClienteService implements ClienteServiceInterface {
    // Declaração do atributo da interface com o repositório
    private final ClienteRepositoryInterface clienteRepository;

    // Injeção da dependência da interface com o repositório via construtor
    public ClienteService(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método que retorna todos os clientes do banco de dados
    public List<ClienteGetDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClienteGetDTO::new).toList();
    }

    // Método que busca um cliente no banco de dados via ID
    public ClienteGetDTO getById(long id) {
        Cliente cliente = getCliente(id);
        return new ClienteGetDTO(cliente);
    }

    // Método que cria um cliente e insere no banco de dados
    public ClienteGetDTO create(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = new Cliente(clienteCreateDTO);
        if(clienteRepository.exists(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        cliente = clienteRepository.create(cliente)
                .orElseThrow(() -> new RuntimeException("Não foi possível realizar o cadastro."));
        return new ClienteGetDTO(cliente);
    }

    // Método que atualiza os dados de um cliente no banco de dados
    public ClienteGetDTO update(long id, ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateCliente(clienteUpdateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClienteGetDTO(cliente);
    }

    // Método que atualiza os dados de um cliente no banco de dados
    public ClienteGetDTO updateAddress(long id, EnderecoCreateDTO enderecoCreateDTO) {
        Cliente cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEndereco(enderecoCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClienteGetDTO(cliente);
    }

    // Método que deleta um cliente do banco de dados via ID
    public boolean delete(long id) {
        return clienteRepository.deleteById(id);
    }

    // Método auxiliar que recupera um Cliente do banco de dados
    private Cliente getCliente(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
    }
}
