package com.luisdias.projeto_integrador_iv_b.db;

import java.util.List;

public interface DatabaseInterface<T, K> {
    T insert(T t);
    T update(T t);
    boolean delete(K id);
    T find(K id);
    List<T> findAll();
    boolean exists(T t);
}
