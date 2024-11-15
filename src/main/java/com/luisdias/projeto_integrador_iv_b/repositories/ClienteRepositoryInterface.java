package com.luisdias.projeto_integrador_iv_b.repositories;

import com.luisdias.projeto_integrador_iv_b.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryInterface {
    Optional<Cliente> findById(long id);
    List<Cliente> findAll();
    boolean exists(Cliente cliente);
    Optional<Cliente> create(Cliente cliente);
    Optional<Cliente> update(Cliente cliente);
    boolean deleteById(long id);
}
