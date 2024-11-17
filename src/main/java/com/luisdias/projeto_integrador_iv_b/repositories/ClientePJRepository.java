package com.luisdias.projeto_integrador_iv_b.repositories;

import com.luisdias.projeto_integrador_iv_b.db.JsonDatabase;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaJuridica;
import com.luisdias.projeto_integrador_iv_b.services.DatabaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Classe responsável por implementar a lógica de acesso ao banco de dados
@Repository
public class ClientePJRepository implements DatabaseRepository<ClientePessoaJuridica, String> {
    // Declaração da dependência de conexão com o banco de dados
    private final JsonDatabase<ClientePessoaJuridica, String> db;

    // Injeção de dependência via construtor
    public ClientePJRepository(JsonDatabase<ClientePessoaJuridica, String> jsonDatabase) {
        this.db = jsonDatabase.dbConnection();
    }

    // Método que recupera um Cliente do banco de dados via ID
    @Override
    public Optional<ClientePessoaJuridica> find(String id) {
        return Optional.ofNullable(db.find(id, ClientePessoaJuridica.class));
    }

    // Método que retorna todos os Clientes do banco de dados
    @Override
    public List<ClientePessoaJuridica> findAll() {
        return db.findAll(ClientePessoaJuridica.class);
    }

    // Método que verifica se um Cliente existe no banco de dados
    @Override
    public boolean exists(ClientePessoaJuridica cliente) {
        return db.exists(cliente);
    }

    // Método que insere um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaJuridica> insert(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.insert(cliente));
    }

    // Método que atualiza os dados de um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaJuridica> update(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    // Método que deleta um Cliente do banco de dados via ID
    @Override
    public boolean delete(String id) {
        return db.delete(id, ClientePessoaJuridica.class);
    }
}
