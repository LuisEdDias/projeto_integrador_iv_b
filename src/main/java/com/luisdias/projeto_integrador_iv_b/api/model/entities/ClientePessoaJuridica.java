package com.luisdias.projeto_integrador_iv_b.api.model.entities;

import com.luisdias.projeto_integrador_iv_b.api.model.sgbd.Identificador;
import com.luisdias.projeto_integrador_iv_b.api.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.Empresa;

import java.util.Objects;

/**
 * A classe ClientePessoaJuridica representa uma entidade a ser persistida no banco de dados
 * e é uma especialização da classe Empresa.
 */
public class ClientePessoaJuridica extends Empresa implements Identificador<String> {
    // ID
    private String id;

    // Construtor padrão
    public ClientePessoaJuridica() {
    }

    /**
     * Construtor que recebe um DTO.
     *
     * @param empresaDTO DTO com os dados para criação de um cliente.
     */
    public ClientePessoaJuridica(EmpresaCreateDTO empresaDTO) {
        super(empresaDTO);
        this.id = empresaDTO.cnpj();
    }

    /**
     * Método que atualiza o Endereço da Empresa.
     *
     * @param enderecoDTO DTO com os dados para atualização do endereço.
     * @return O objeto ClientePessoaJuridica atualizado.
     */
    public ClientePessoaJuridica updateEndereco(EnderecoCreateDTO enderecoDTO) {
        super.setEndereco(enderecoDTO);
        return this;
    }

    /**
     * Método que atualiza o Endereço do proprietário.
     *
     * @param enderecoDTO DTO com os dados para atualização do endereço.
     * @return O objeto ClientePessoaJuridica atualizado.
     */
    public ClientePessoaJuridica updateEnderecoProprietario(EnderecoCreateDTO enderecoDTO) {
        super.setEnderecoProprietario(enderecoDTO);
        return this;
    }

    /**
     * Método que atualiza os dados do proprietário.
     *
     * @param updateDTO DTO com as informações para atualizar os dados do proprietário.
     * @return O objeto ClientePessoaJuridica atualizado.
     */
    public ClientePessoaJuridica updateDadosProprietario(PessoaUpdateDTO updateDTO) {
        super.updateProprietario(updateDTO);
        return this;
    }

    /**
     * Método que insere um novo proprietário.
     *
     * @param createDTO DTO com os dados para criar um proprietário.
     * @return O objeto ClientePessoaJuridica atualizado.
     */
    public ClientePessoaJuridica newProprietario(PessoaCreateDTO createDTO) {
        super.setProprietario(createDTO);
        return this;
    }

    /**
     * Implementação do método exigido pelo banco de dados.
     *
     * @return O ID do objeto.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sobrescrevendo equals para garantir que dois Clientes com os mesmos valores
     * de CNPJ sejam considerados iguais.
     *
     * @param o Root Class Object.
     * @return True caso os dois objetos sejam considerados iguais.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePessoaJuridica cliente = (ClientePessoaJuridica) o;
        return Objects.equals(getCnpj(), cliente.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnpj());
    }
}
