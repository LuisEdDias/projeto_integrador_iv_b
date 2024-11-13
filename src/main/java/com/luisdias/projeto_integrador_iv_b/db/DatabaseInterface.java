package com.luisdias.projeto_integrador_iv_b.db;

import java.util.List;

public interface DatabaseInterface<T, K> {
    T findById(K key);
    List<T> findAll();
    T insert(T t);
    T update(T t);
    boolean delete(K key);
}
