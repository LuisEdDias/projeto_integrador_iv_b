package com.luisdias.projeto_integrador_iv_b.services.cliente.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaFisica;
import com.luisdias.projeto_integrador_iv_b.repositories.cliente.pessoafisica.ClientePFRepositoryInterface;
import com.luisdias.projeto_integrador_iv_b.dtos.cliente.pessoafisica.ClientePFGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// Classe responsável por implementar as regras de negócio relacionadas à classe Cliente
@Service
public class ClientePFService implements ClientePFServiceInterface {
    // Declaração do atributo da interface com o repositório
    private final ClientePFRepositoryInterface clienteRepository;

    // Injeção da dependência da interface com o repositório via construtor
    public ClientePFService(ClientePFRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método que retorna todos os clientes do banco de dados
    public List<ClientePFGetDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClientePFGetDTO::new).toList();
    }

    // Método que busca um cliente no banco de dados via ID
    public ClientePFGetDTO getById(long id) {
        ClientePessoaFisica cliente = getCliente(id);
        return new ClientePFGetDTO(cliente);
    }

    // Método que cria um cliente e insere no banco de dados
    public ClientePFGetDTO create(PessoaCreateDTO createDTO) {
        ClientePessoaFisica cliente = new ClientePessoaFisica(createDTO);
        if(clienteRepository.exists(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        cliente = clienteRepository.create(cliente)
                .orElseThrow(() -> new RuntimeException("Não foi possível realizar o cadastro."));
        return new ClientePFGetDTO(cliente);
    }

    // Método que atualiza os dados de um cliente no banco de dados
    public ClientePFGetDTO update(long id, PessoaUpdateDTO updateDTO) {
        ClientePessoaFisica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateCliente(updateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePFGetDTO(cliente);
    }

    // Método que atualiza os dados de um cliente no banco de dados
    public ClientePFGetDTO updateAddress(long id, EnderecoCreateDTO enderecoCreateDTO) {
        ClientePessoaFisica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEndereco(enderecoCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePFGetDTO(cliente);
    }

    // Método que deleta um cliente do banco de dados via ID
    public boolean delete(long id) {
        return clienteRepository.deleteById(id);
    }

    // Método auxiliar que recupera um Cliente do banco de dados
    private ClientePessoaFisica getCliente(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
    }
}
