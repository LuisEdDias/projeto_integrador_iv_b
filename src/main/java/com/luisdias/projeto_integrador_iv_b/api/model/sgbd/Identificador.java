package com.luisdias.projeto_integrador_iv_b.api.model.sgbd;

/**
 * Interface que deve ser implementada por qualquer entidade que deva ser persistida utilizando
 * o SGBD JsonDatabase.
 *
 * @param <K> Tipo do ID empregado pela entidade.
 */
public interface Identificador<K> {
    /**
     * @return ID da entidade.
     */
    K getId();
}
