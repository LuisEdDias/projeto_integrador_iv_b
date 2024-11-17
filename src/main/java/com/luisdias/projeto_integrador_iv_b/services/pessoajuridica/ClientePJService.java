package com.luisdias.projeto_integrador_iv_b.services.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.dtos.pessoajuridica.ClientePJGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaJuridica;
import com.luisdias.projeto_integrador_iv_b.services.DatabaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// Classe responsável por implementar as regras de negócio relacionadas à classe Cliente PJ
@Service
public class ClientePJService implements com.luisdias.projeto_integrador_iv_b.controllers.pessoajuridica.ClientePJService {
    // Declaração do atributo da interface com o repositório
    private final DatabaseRepository<ClientePessoaJuridica, String> clienteRepository;

    // Injeção da dependência da interface com o repositório via construtor
    public ClientePJService(DatabaseRepository<ClientePessoaJuridica, String> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método que retorna todos os clientes do banco de dados
    @Override
    public List<ClientePJGetDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClientePJGetDTO::new).toList();
    }

    // Método que busca um cliente no banco de dados via ID
    @Override
    public ClientePJGetDTO getById(String id) {
        ClientePessoaJuridica cliente = getCliente(id);
        return new ClientePJGetDTO(cliente);
    }

    // Método que cria um cliente e insere no banco de dados
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

    // Método que atualiza o Endereço da Empresa no banco de dados
    @Override
    public ClientePJGetDTO updateEndereco(String id, EnderecoCreateDTO enderecoCreateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEndereco(enderecoCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    // Método que atualiza o Endereço do proprietario no banco de dados
    @Override
    public ClientePJGetDTO updateEnderecoProprietario(String id, EnderecoCreateDTO enderecoCreateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateEnderecoProprietario(enderecoCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    // Método que atualiza os dados do proprietário no banco de dados
    @Override
    public ClientePJGetDTO updateDadosProprietario(String id, PessoaUpdateDTO pessoaUpdateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.updateDadosProprietario(pessoaUpdateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    // Método que salva um novo proprietário no banco de dados
    @Override
    public ClientePJGetDTO newProprietario(String id, PessoaCreateDTO pessoaCreateDTO) {
        ClientePessoaJuridica cliente = getCliente(id);
        cliente = clienteRepository.update(cliente.newProprietario(pessoaCreateDTO))
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados do Cliente."));
        return new ClientePJGetDTO(cliente);
    }

    // Método que deleta um cliente do banco de dados via ID
    @Override
    public boolean delete(String id) {
        return clienteRepository.delete(id);
    }

    // Método auxiliar que recupera um Cliente do banco de dados
    private ClientePessoaJuridica getCliente(String id) {
        return clienteRepository.find(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
    }
}
