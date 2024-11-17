package com.luisdias.projeto_integrador_iv_b.services;

import com.luisdias.projeto_integrador_iv_b.db.Identificador;

import java.util.List;
import java.util.Optional;

public interface DatabaseRepository<T extends Identificador<K>, K> {
    Optional<T> insert(T t);
    Optional<T> update(T t);
    boolean delete(K id);
    Optional<T> find(K id);
    List<T> findAll();
    boolean exists(T t);
}
