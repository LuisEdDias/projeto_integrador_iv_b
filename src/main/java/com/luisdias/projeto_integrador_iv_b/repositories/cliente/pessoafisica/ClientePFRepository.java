package com.luisdias.projeto_integrador_iv_b.repositories.cliente.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.infra.db.DatabaseInterface;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaFisica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Classe responsável por implementar a lógica de acesso ao banco de dados
@Repository
public class ClientePFRepository implements ClientePFRepositoryInterface {
    // Declaração do atributo da interface com o banco de dados
    private final DatabaseInterface<ClientePessoaFisica, Long> db;

    // Injeção da dependência da interface com o banco de dados
    public ClientePFRepository(DatabaseInterface<ClientePessoaFisica, Long> db) {
        this.db = db.dbConnection();
    }

    // Método que recupera um Cliente do banco de dados via ID
    @Override
    public Optional<ClientePessoaFisica> findById(long id) {
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
    public Optional<ClientePessoaFisica> create(ClientePessoaFisica cliente) {
        return Optional.ofNullable(db.insert(cliente));
    }

    // Método que atualiza os dados de um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaFisica> update(ClientePessoaFisica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    // Método que deleta um Cliente do banco de dados via ID
    @Override
    public boolean deleteById(long id) {
        return db.delete(id, ClientePessoaFisica.class);
    }
}
