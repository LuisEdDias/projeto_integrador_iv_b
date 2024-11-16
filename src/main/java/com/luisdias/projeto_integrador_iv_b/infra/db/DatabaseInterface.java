package com.luisdias.projeto_integrador_iv_b.infra.db;

import java.util.List;

public interface DatabaseInterface<T extends Identificador<K>, K> {
    DatabaseInterface<T, K> dbConnection();
    T insert(T t);
    T update(T t);
    boolean delete(K id, Class<T> clazz);
    T find(K id, Class<T> clazz);
    List<T> findAll(Class<T> clazz);
    boolean exists(T t);
}
