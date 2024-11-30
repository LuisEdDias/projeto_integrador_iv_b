package com.luisdias.projeto_integrador_iv_b.api.controllers.clientepf;

import com.luisdias.projeto_integrador_iv_b.api.dtos.clientepf.ClientePFGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;

import java.util.List;

/**
 * Interface com métodos para gerenciar CRUD de clientes pessoa física
 */
public interface ClientePFService {
    /**
     * Recupera todos os clientes do banco de dados.
     */
    List<ClientePFGetDTO> getAll();

    /**
     * Recupera um cliente com base no ID.
     *
     * @param id ID do cliente.
     * @return Uma instância de ClientePFGetDTO.
     */
    ClientePFGetDTO getById(long id);

    /**
     * Cadastra um novo cliente.
     *
     * @param createDTO DTO para criação do cliente.
     * @return Uma instância de ClientePFGetDTO.
     */
    ClientePFGetDTO create(PessoaCreateDTO createDTO);

    /**
     * Atualiza os dados de um cliente com base no ID.
     *
     * @param id        ID do cliente.
     * @param updateDTO DTO para atualizar dados do cliente.
     * @return Uma instância de ClientePFGetDTO.
     */
    ClientePFGetDTO update(long id, PessoaUpdateDTO updateDTO);

    /**
     * Atualiza o endereço de um cliente com base no ID.
     *
     * @param id          ID do cliente.
     * @param enderecoDTO DTO para atualizar o endereço do cliente.
     * @return Uma instância de ClientePFGetDTO.
     */
    ClientePFGetDTO updateAddress(long id, EnderecoCreateDTO enderecoDTO);

    /**
     * Deleta um cliente com base no ID.
     *
     * @param id ID do cliente.
     * @return True se o cliente for deletado ou caso contrário false.
     */
    boolean delete(long id);
}
