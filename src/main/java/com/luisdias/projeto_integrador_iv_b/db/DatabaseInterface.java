package com.luisdias.projeto_integrador_iv_b.db;

import java.util.List;
import java.util.Optional;

public interface DatabaseInterface<T, K> {
    Optional<T> findById(K key);
    List<T> findAll();
    T insert(T t);
    T update(T t);
    boolean delete(K key);
}
