package com.luisdias.projeto_integrador_iv_b.api.model.repositories;

import com.luisdias.projeto_integrador_iv_b.api.model.services.DatabaseRepository;
import com.luisdias.projeto_integrador_iv_b.api.model.sgbd.JsonDatabase;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaFisica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por implementar a lógica de acesso ao banco de dados para Pessoa Física.
 */
@Repository
public class ClientePFRepository implements DatabaseRepository<ClientePessoaFisica, Long> {
    // Declaração da dependência de conexão com o banco de dados
    private final JsonDatabase<ClientePessoaFisica, Long> db;

    // Injeção de dependência via construtor
    public ClientePFRepository(JsonDatabase<ClientePessoaFisica, Long> jsonDatabase) {
        this.db = jsonDatabase.dbConnection();
    }

    @Override
    public Optional<ClientePessoaFisica> find(Long id) {
        return Optional.ofNullable(db.find(id, ClientePessoaFisica.class));
    }

    @Override
    public List<ClientePessoaFisica> findAll() {
        return db.findAll(ClientePessoaFisica.class);
    }

    @Override
    public boolean exists(ClientePessoaFisica cliente) {
        return db.exists(cliente);
    }

    @Override
    public Optional<ClientePessoaFisica> insert(ClientePessoaFisica clientePessoaFisica) {
        return Optional.ofNullable(db.insert(clientePessoaFisica));
    }

    @Override
    public Optional<ClientePessoaFisica> update(ClientePessoaFisica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    @Override
    public boolean delete(Long id) {
        return db.delete(id, ClientePessoaFisica.class);
    }
}
