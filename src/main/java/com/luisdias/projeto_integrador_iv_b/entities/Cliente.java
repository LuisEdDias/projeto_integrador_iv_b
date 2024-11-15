package com.luisdias.projeto_integrador_iv_b.entities;

import com.luisdias.projeto_integrador_iv_b.config.annotations.Id;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

//A classe Cliente representa uma entidade a ser persistida no banco de dados
public class Cliente {
    //ID
    @Id
    private long clientId;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    //Object Value utilizado para compor a classe
    private Endereco endereco;

    //Construtor usado pelo banco de dados
    public Cliente(){}

    //Construtor que recebe um DTO
    public Cliente(ClienteCreateDTO clienteDTO){
        long id = Objects.hash(clienteDTO.cpf());
        this.clientId = id < 0 ? (id * id) : id;
        this.cpf = clienteDTO.cpf();
        this.nome = clienteDTO.nome();
        this.dataNascimento = getDate(clienteDTO.dataNascimento());
        this.telefone = clienteDTO.telefone();
        this.endereco = new Endereco(clienteDTO.endereco());
    }

    //Função para atualizar os dados do Cliente
    public Cliente updateCliente(ClienteUpdateDTO clienteDTO){
        this.nome = clienteDTO.nome();
        this.dataNascimento = getDate(clienteDTO.dataNascimento());
        this.telefone = clienteDTO.telefone();
        return this;
    }

    //Função para atualizar o Endereço
    public Cliente updateEndereco(EnderecoCreateDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
        return this;
    }

    //Getters
    public String getCpf() {
        return cpf;
    }

    public long getClientId() {
        return clientId;
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

    //Função privada para converter a String date no tipo Date
    private Date getDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data em formato inválido.");
        }
    }

    // Sobrescrevendo equals e hashCode para garantir que dois Cliente com os mesmos valores
    // de CPF sejam considerados iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return clientId == cliente.clientId && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, cpf);
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
