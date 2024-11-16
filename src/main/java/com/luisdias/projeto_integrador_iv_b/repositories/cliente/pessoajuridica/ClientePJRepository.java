package com.luisdias.projeto_integrador_iv_b.repositories.cliente.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.infra.db.DatabaseInterface;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaJuridica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Classe responsável por implementar a lógica de acesso ao banco de dados
@Repository
public class ClientePJRepository implements ClientePJRepositoryInterface {
    // Declaração do atributo da interface com o banco de dados
    private final DatabaseInterface<ClientePessoaJuridica, String> db;

    // Injeção da dependência da interface com o banco de dados
    public ClientePJRepository(DatabaseInterface<ClientePessoaJuridica, String> db) {
        this.db = db.dbConnection();
    }

    // Método que recupera um Cliente do banco de dados via ID
    @Override
    public Optional<ClientePessoaJuridica> findById(String id) {
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
    public Optional<ClientePessoaJuridica> create(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.insert(cliente));
    }

    // Método que atualiza os dados de um Cliente no banco de dados
    @Override
    public Optional<ClientePessoaJuridica> update(ClientePessoaJuridica cliente) {
        return Optional.ofNullable(db.update(cliente));
    }

    // Método que deleta um Cliente do banco de dados via ID
    @Override
    public boolean deleteById(String id) {
        return db.delete(id, ClientePessoaJuridica.class);
    }
}
