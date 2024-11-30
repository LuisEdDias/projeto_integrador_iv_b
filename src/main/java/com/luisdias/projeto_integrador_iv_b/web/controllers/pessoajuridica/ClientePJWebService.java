package com.luisdias.projeto_integrador_iv_b.web.controllers.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.web.dtos.*;

import java.util.List;

/**
 * Interface com métodos CRUD para clientes pessoa jurídica
 * responsável gerenciar a interação com o back-end.
 */
public interface ClientePJWebService {
    /**
     * Retorna uma lista de {@link ClientePjDTO}. Pode retornar uma lista vazia.
     *
     * @return Lista de {@link ClientePjDTO}.
     */
    List<ClientePjDTO> getAll();

    /**
     * Busca por um cliente tendo o ID como referência.
     *
     * @param id ID à ser buscado.
     * @return Retorna um {@link ClientePjDTO} em caso de sucesso.
     */
    ClientePjDTO getById(String id);

    /**
     * Cria um novo cliente.
     *
     * @param empresa DTO com os dados de criação.
     * @return Retorna um {@link ClientePjDTO}.
     */
    ClientePjDTO create(EmpresaDTO empresa);

    /**
     * Atualiza o endereço da empresa com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param endereco DTO com os dados do novo endereço.
     */
    void updateEndereco(String id, EnderecoDTO endereco);

    /**
     * Atualiza o endereço do proprietário com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param endereco DTO com os dados do novo endereço.
     */
    void updateEnderecoProprietario(String id, EnderecoDTO endereco);

    /**
     * Atualiza os dados do proprietário com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param pessoa DTO com os dados para atualização.
     */
    void updateDadosProprietario(String id, PessoaDTO pessoa);

    /**
     * Cria um novo com base no ID.
     *
     * @param id ID do cliente à ser atualizado.
     * @param pessoa DTO com os dados para criação do novo proprietário.
     */
    void newProprietario(String id, PessoaDTO pessoa);

    /**
     * Deleta um cliente com base no ID.
     *
     * @param id ID do cliente à ser deletado.
     */
    void delete(String id);
}
