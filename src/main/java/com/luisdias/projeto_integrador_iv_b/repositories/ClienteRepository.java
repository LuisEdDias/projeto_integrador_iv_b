package com.luisdias.projeto_integrador_iv_b.repositories;

import com.luisdias.projeto_integrador_iv_b.db.DatabaseInterface;
import com.luisdias.projeto_integrador_iv_b.entities.Cliente;

import java.util.List;
import java.util.Optional;

// Classe responsável por implementar a lógica de acesso ao banco de dados
public class ClienteRepository implements ClienteRepositoryInterface {
    // Declaração do atributo da interface com o banco de dados
    private final DatabaseInterface<Cliente, Long> db;

    // Injeção da dependência da interface com o banco de dados
    public ClienteRepository(DatabaseInterface<Cliente, Long> db) {
        this.db = db;
    }

    // Método que recupera um Cliente do banco de dados via ID
    @Override
    public Optional<Cliente> findById(long id) {
        return Optional.ofNullable(db.find(id));
    }

    // Método que retorna todos os Clientes do banco de dados
    @Override
    public List<Cliente> findAll() {
        return db.findAll();
    }

    // Método que verifica se um Cliente existe no banco de dados
    @Override
    public boolean exists(Cliente cliente) {
        return db.exists(cliente);
    }

    // Método que insere um Cliente no banco de dados
    @Override
    public Optional<Cliente> create(Cliente cliente) {
        return Optional.ofNullable(db.insert(cliente));
    }

    // Método que atualiza os dados de um Cliente no banco de dados
    @Override
    public Optional<Cliente> update(Cliente cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    // Método que deleta um Cliente do banco de dados via ID
    @Override
    public boolean deleteById(long id) {
        return db.delete(id);
    }
}
