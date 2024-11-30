package com.luisdias.projeto_integrador_iv_b.api.controllers.clientepj;

import com.luisdias.projeto_integrador_iv_b.api.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.clientepj.ClientePJGetDTO;

import java.util.List;

/**
 * Interface com métodos para gerenciar CRUD de clientes pessoa juridica
 */
public interface ClientePJService {
    /**
     * Recupera todos os clientes do banco de dados.
     */
    List<ClientePJGetDTO> getAll();

    /**
     * Recupera um cliente com base no ID.
     *
     * @param id ID do cliente.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO getById(String id);

    /**
     * Cadastra um novo cliente.
     *
     * @param createDTO DTO para criação do cliente.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO create(EmpresaCreateDTO createDTO);

    /**
     * Atualiza o endereço de um cliente com base no ID.
     *
     * @param id          ID do cliente.
     * @param enderecoDTO DTO para atualizar o endereço do cliente.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO updateEndereco(String id, EnderecoCreateDTO enderecoDTO);

    /**
     * Atualiza o endereço do proprietário com base no ID.
     *
     * @param id          ID do cliente.
     * @param enderecoDTO DTO para atualizar o endereço do proprietário.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO updateEnderecoProprietario(String id, EnderecoCreateDTO enderecoDTO);

    /**
     * Atualiza os dados do proprietário com base no ID.
     *
     * @param id        ID do cliente.
     * @param updateDTO DTO para atualizar dados do cliente.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO updateDadosProprietario(String id, PessoaUpdateDTO updateDTO);

    /**
     * Cria um novo proprietário para o cliente com o ID especificado.
     *
     * @param id        ID do cliente.
     * @param createDTO DTO para criar um novo proprietário.
     * @return Uma instância de ClientePJGetDTO.
     */
    ClientePJGetDTO newProprietario(String id, PessoaCreateDTO createDTO);

    /**
     * Deleta um cliente com base no ID.
     *
     * @param id ID do cliente.
     * @return True se o cliente for deletado ou caso contrário false.
     */
    boolean delete(String id);
}
