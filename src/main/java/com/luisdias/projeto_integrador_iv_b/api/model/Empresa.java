package com.luisdias.projeto_integrador_iv_b.api.model;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.empresa.EmpresaCreateDTO;

/**
 * A classe é uma abstração de uma empresa e contém os dados para representa-lá na aplicação.
 */
public class Empresa {
    private String razaoSocial;
    private String cnpj;
    // Object Value utilizado para compor a classe
    private Endereco endereco;
    // Classe Pessoa compõe a classe Empresa
    private Pessoa proprietario;

    // Construtor padrão
    public Empresa() {}

    /**
     * Construtor que recebe um DTO com os dados necessários para criar uma nova empresa.
     *
     * @param empresaDTO DTO com os dados da empresa.
     */
    public Empresa(EmpresaCreateDTO empresaDTO){
        this.razaoSocial = empresaDTO.razaoSocial();
        this.cnpj = empresaDTO.cnpj();
        this.endereco = new Endereco(empresaDTO.endereco());
        this.proprietario = new Pessoa(empresaDTO.proprietario());
    }

    /**
     * Atualiza o endereço da empresa.
     *
     * @param enderecoDTO DTO com os dados do novo endereço.
     */
    public void setEndereco(EnderecoCreateDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
    }

    /**
     * Atualiza os dados do proprietário.
     *
     * @param proprietarioDTO DTO com os dados para atualização.
     */
    public void updateProprietario(PessoaUpdateDTO proprietarioDTO){
        this.proprietario.update(proprietarioDTO);
    }

    /**
     * Atualiza o endereço do proprietário.
     *
     * @param enderecoDTO DTO com os dados do novo endereço.
     */
    public void setEnderecoProprietario(EnderecoCreateDTO enderecoDTO){
        this.proprietario.updateEndereco(enderecoDTO);
    }

    /**
     * Troca o proprietário atual por um novo.
     *
     * @param proprietarioDTO DTO com os dados do novo proprietário.
     */
    public void setProprietario(PessoaCreateDTO proprietarioDTO){
        this.proprietario = new Pessoa(proprietarioDTO);
    }

    //Getters
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return "Razão social: " + razaoSocial + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Endereco: " + "\n" + endereco + "\n" +
                "Proprietario: " + "\n" + proprietario;
    }
}
