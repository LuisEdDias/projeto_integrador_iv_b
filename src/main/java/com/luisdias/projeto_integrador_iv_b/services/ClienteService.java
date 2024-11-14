package com.luisdias.projeto_integrador_iv_b.services;

import com.luisdias.projeto_integrador_iv_b.db.DatabaseInterface;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.entities.Cliente;

import java.util.List;
import java.util.NoSuchElementException;

// Classe por implementar as regras de negócio relacionadas à classe Cliente
public class ClienteService {
    // Declaração do atributo da interface do banco de dados
    private final DatabaseInterface<Cliente, Integer> database;

    // Injeção da dependência do banco de dados via construtor
    public ClienteService(DatabaseInterface<Cliente, Integer> database) {
        this.database = database;
    }

    // Método que retorna todos os clientes do banco de dados
    public List<ClienteGetDTO> getAll() {
        return database.findAll().stream().map(ClienteGetDTO::new).toList();
    }

    // Método que busca um cliente no banco de dados via ID
    public ClienteGetDTO getById(int id) {
        Cliente cliente = database.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));;
        return new ClienteGetDTO(cliente);

    }

    // Método que cria um cliente e insere no banco de dados
    public ClienteGetDTO create(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = database.insert(new Cliente(clienteCreateDTO));
        return new ClienteGetDTO(cliente);
    }

    // Método que atualiza os dados de um cliente no banco de dados
    public ClienteGetDTO update(int id, ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = database.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado."));
        cliente = database.update(cliente);
        return new ClienteGetDTO(cliente);
    }

    // Método que deleta um cliente do banco de dados via ID
    public boolean delete(int id) {
        return database.delete(id);
    }
}
