package com.luisdias.projeto_integrador_iv_b.api.model.services;

import com.luisdias.projeto_integrador_iv_b.api.model.sgbd.Identificador;

import java.util.List;
import java.util.Optional;

/**
 * Interface genérica de acesso ao banco de dados.
 *
 * @param <T> Tipo da entidade a ser persistida.
 * @param <K> Tipo do ID da entidade.
 */
public interface DatabaseRepository<T extends Identificador<K>, K> {
    /**
     * Insere um novo registro no banco de dados.
     *
     * @param t Entidade à ser persistida.
     * @return Optional da entidade salva no banco.
     */
    Optional<T> insert(T t);

    /**
     * Atualiza um registro no banco de dados.
     *
     * @param t Entidade à ser atualizada.
     * @return Optional da entidade atualizada.
     */
    Optional<T> update(T t);

    /**
     * Deleta um registro com base no ID.
     *
     * @param id ID do registro a ser deletado.
     * @return Retorna True em caso de sucesso ou False em caso contrário.
     */
    boolean delete(K id);

    /**
     * Busca um registro no banco de dados com base no ID.
     *
     * @param id ID do registro buscado.
     * @return Optional.
     */
    Optional<T> find(K id);

    /**
     * Busca todos os registros de um tipo no banco de dados.
     *
     * @return Lista com os dados encontrados. Pode retornar uma lista vazia.
     */
    List<T> findAll();

    /**
     * Verifica a existência de um registro no banco de dados.
     *
     * @param t Objeto a verificar.
     * @return True caso o objeto já exista no banco de dados ou False caso contrário.
     */
    boolean exists(T t);
}
