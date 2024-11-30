package com.luisdias.projeto_integrador_iv_b.web.controllers.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.web.dtos.*;

import java.util.List;

/**
 * Interface com métodos CRUD para clientes pessoa física
 * responsável gerenciar a interação com o back-end.
 */
public interface ClientePFWebService {
    /**
     * Retorna uma lista de {@link ClientePfDTO}. Pode retornar uma lista vazia.
     *
     * @return Lista de {@link ClientePfDTO}.
     */
    List<ClientePfDTO> getAll();

    /**
     * Busca por um cliente tendo o ID como referência.
     *
     * @param id ID à ser buscado.
     * @return Retorna um {@link ClientePfDTO} em caso de sucesso.
     */
    ClientePfDTO getById(Long id);

    /**
     * Cria um novo cliente.
     *
     * @param pessoa DTO com os dados de criação.
     * @return Retorna um {@link ClientePfDTO}.
     */
    ClientePfDTO create(PessoaDTO pessoa);

    /**
     * Atualiza os dados de um cliente com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param pessoa DTO com os dados para atualização.
     */
    void update(long id, PessoaDTO pessoa);

    /**
     * Atualiza o endereço do cliente com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param endereco DTO com os dados do novo endereço.
     */
    void updateAddress(long id, EnderecoDTO endereco);

    /**
     * Deleta um cliente com base no ID.
     *
     * @param id ID do cliente à ser deletado.
     */
    void delete(long id);
}
