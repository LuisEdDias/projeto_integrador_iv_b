package com.luisdias.projeto_integrador_iv_b.repositories.cliente.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaJuridica;

import java.util.List;
import java.util.Optional;

public interface ClientePJRepositoryInterface {
    Optional<ClientePessoaJuridica> findById(String id);
    List<ClientePessoaJuridica> findAll();
    boolean exists(ClientePessoaJuridica cliente);
    Optional<ClientePessoaJuridica> create(ClientePessoaJuridica cliente);
    Optional<ClientePessoaJuridica> update(ClientePessoaJuridica cliente);
    boolean deleteById(String id);
}
