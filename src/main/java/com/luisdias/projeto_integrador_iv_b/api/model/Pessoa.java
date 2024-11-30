package com.luisdias.projeto_integrador_iv_b.api.model;

import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;

import java.util.Date;

/**
 * A classe é uma abstração de uma pessoa e contém os dados para representa-lá na aplicação.
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    // Object Value utilizado para compor a classe
    private Endereco endereco;

    // Construtor padrão
    public Pessoa() {
    }

    /**
     * Construtor que recebe um DTO com os dados para criação de uma pessoa.
     *
     * @param createDTO DTO com os dados da pessoa.
     */
    public Pessoa(PessoaCreateDTO createDTO){
        this.cpf = createDTO.cpf();
        this.nome = createDTO.nome();
        this.dataNascimento = createDTO.dataNascimento();
        this.telefone = createDTO.telefone();
        this.endereco = new Endereco(createDTO.endereco());
    }

    /**
     * Atualiza os dados de uma pessoa.
     *
     * @param updateDTO DTO com os dados para atualização.
     */
    public void update(PessoaUpdateDTO updateDTO){
        this.nome = updateDTO.nome();
        this.dataNascimento = updateDTO.dataNascimento();
        this.telefone = updateDTO.telefone();
    }

    /**
     * Atualiza o endereço de uma pessoa.
     *
     * @param enderecoDTO DTO com os dados do novo endereço.
     */
    public void updateEndereco(EnderecoCreateDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de nascimento: " + dataNascimento + "\n" +
                "Telefone: " + telefone + "\n" +
                "Endereco: " + "\n" + endereco;
    }
}
