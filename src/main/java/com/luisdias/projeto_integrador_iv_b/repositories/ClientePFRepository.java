package com.luisdias.projeto_integrador_iv_b.repositories;

import com.luisdias.projeto_integrador_iv_b.db.JsonDatabase;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaFisica;
import com.luisdias.projeto_integrador_iv_b.services.DatabaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Classe responsável por implementar a lógica de acesso ao banco de dados
@Repository
public class ClientePFRepository implements DatabaseRepository<ClientePessoaFisica, Long> {
    // Declaração da dependência de conexão com o banco de dados
    private final JsonDatabase<ClientePessoaFisica, Long> db;

    // Injeção de dependência via construtor
    public ClientePFRepository(JsonDatabase<ClientePessoaFisica, Long> jsonDatabase) {
        this.db = jsonDatabase.dbConnection();
    }

    // Método que recupera um Cliente do banco de dados via ID
    @Override
    public Optional<ClientePessoaFisica> find(Long id) {
        return Optional.ofNullable(db.find(id, ClientePessoaFisica.class));
    }

    // Método que retorna todos os Clientes do banco de dados
    @Override
    public List<ClientePessoaFisica> findAll() {
        return db.findAll(ClientePessoaFisica.class);
    }

    // Método que verifica se um Cliente existe no banco de dados
    @Override
    public boolean exists(ClientePessoaFisica cliente) {
        return db.exists(cliente);
    }

    // Método que insere um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaFisica> insert(ClientePessoaFisica clientePessoaFisica) {
        return Optional.ofNullable(db.insert(clientePessoaFisica));
    }

    // Método que atualiza os dados de um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaFisica> update(ClientePessoaFisica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    // Método que deleta um Cliente do banco de dados via ID
    @Override
    public boolean delete(Long id) {
        return db.delete(id, ClientePessoaFisica.class);
    }
}
