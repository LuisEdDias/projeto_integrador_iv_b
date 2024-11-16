package com.luisdias.projeto_integrador_iv_b.model;

import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
    String cpf;
    String nome;
    Date dataNascimento;
    String telefone;
    //Object Value utilizado para compor a classe
    Endereco endereco;

    // Construtor padrão
    public Pessoa() {
    }

    //Construtor que recebe um DTO
    public Pessoa(PessoaCreateDTO pessoaCreateDTO){
        this.cpf = pessoaCreateDTO.cpf();
        this.nome = pessoaCreateDTO.nome();
        this.dataNascimento = getDate(pessoaCreateDTO.dataNascimento());
        this.telefone = pessoaCreateDTO.telefone();
        this.endereco = new Endereco(pessoaCreateDTO.endereco());
    }

    //Função para atualizar os dados do Cliente
    public Pessoa update(PessoaUpdateDTO pessoaUpdateDTO){
        this.nome = pessoaUpdateDTO.nome();
        this.dataNascimento = getDate(pessoaUpdateDTO.dataNascimento());
        this.telefone = pessoaUpdateDTO.telefone();
        return this;
    }

    //Função para atualizar o Endereço
    public Pessoa updateEndereco(EnderecoCreateDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
        return this;
    }

    //Getters
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

    //Método auxiliar para converter a String date no tipo Date
    private Date getDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data em formato inválido.");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de nascimento: " + dataNascimento + "\n" +
                "Telefone: " + telefone + "\n" +
                "Endereco: " + "\n" +
                endereco;
    }
}
