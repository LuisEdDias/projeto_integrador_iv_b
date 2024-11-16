package com.luisdias.projeto_integrador_iv_b.repositories.cliente.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaFisica;

import java.util.List;
import java.util.Optional;

public interface ClientePFRepositoryInterface {
    Optional<ClientePessoaFisica> findById(long id);
    List<ClientePessoaFisica> findAll();
    boolean exists(ClientePessoaFisica cliente);
    Optional<ClientePessoaFisica> create(ClientePessoaFisica cliente);
    Optional<ClientePessoaFisica> update(ClientePessoaFisica cliente);
    boolean deleteById(long id);
}
