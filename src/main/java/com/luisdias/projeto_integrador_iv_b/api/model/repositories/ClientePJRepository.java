package com.luisdias.projeto_integrador_iv_b.api.model.repositories;

import com.luisdias.projeto_integrador_iv_b.api.model.services.DatabaseRepository;
import com.luisdias.projeto_integrador_iv_b.api.model.sgbd.JsonDatabase;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaJuridica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por implementar a lógica de acesso ao banco de dados para Pessoa Jurídica.
 */
@Repository
public class ClientePJRepository implements DatabaseRepository<ClientePessoaJuridica, String> {
    // Declaração da dependência de conexão com o banco de dados
    private final JsonDatabase<ClientePessoaJuridica, String> db;

    // Injeção de dependência via construtor
    public ClientePJRepository(JsonDatabase<ClientePessoaJuridica, String> jsonDatabase) {
        this.db = jsonDatabase.dbConnection();
    }

    @Override
    public Optional<ClientePessoaJuridica> find(String id) {
        return Optional.ofNullable(db.find(id, ClientePessoaJuridica.class));
    }

    @Override
    public List<ClientePessoaJuridica> findAll() {
        return db.findAll(ClientePessoaJuridica.class);
    }

    @Override
    public boolean exists(ClientePessoaJuridica cliente) {
        return db.exists(cliente);
    }

    @Override
    public Optional<ClientePessoaJuridica> insert(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.insert(cliente));
    }

    @Override
    public Optional<ClientePessoaJuridica> update(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    @Override
    public boolean delete(String id) {
        return db.delete(id, ClientePessoaJuridica.class);
    }
}
