package com.luisdias.projeto_integrador_iv_b.model;

import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;

// Classe genérica que representa uma empresa
public class Empresa {
    private String razaoSocial;
    private String cnpj;
    // Object Value utilizado para compor a classe
    private Endereco endereco;
    // Classe Pessoa compõe a classe Empresa
    private Pessoa proprietario;

    // Construtor padrão
    public Empresa() {}

    // Construtor que recebe um DTO
    public Empresa(EmpresaCreateDTO empresaDTO){
        this.razaoSocial = empresaDTO.razaoSocial();
        this.cnpj = empresaDTO.cnpj();
        this.endereco = new Endereco(empresaDTO.endereco());
        this.proprietario = new Pessoa(empresaDTO.proprietario());
    }

    // Método para atualizar o endereço da empresa
    public void updateEndereco(EnderecoCreateDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
    }

    // Método para atualizar os dados do Proprietário
    public void updateProprietario(PessoaUpdateDTO proprietarioDTO){
        this.proprietario.update(proprietarioDTO);
    }

    // Método para atualizar o endereço do Proprietário
    public void updateEnderecoProprietario(EnderecoCreateDTO enderecoDTO){
        this.proprietario.updateEndereco(enderecoDTO);
    }

    // Método para troca do Proprietário
    public void newProprietario(PessoaCreateDTO proprietarioDTO){
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
