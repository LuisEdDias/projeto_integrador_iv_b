package com.luisdias.projeto_integrador_iv_b.entities;

import com.luisdias.projeto_integrador_iv_b.dtos.CreateClienteDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.CreateEnderecoDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.UpdateClienteDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

//A classe Cliente representa uma entidade a ser persistida no banco de dados
public class Cliente {
    //ID
    private final int clientId;
    private final String cpf;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    //Object Value utilizado para compor a classe
    private Endereco endereco;

    //Construtor
    public Cliente(CreateClienteDTO clienteDTO){
        this.clientId = Integer.getInteger(clienteDTO.cpf());
        this.cpf = clienteDTO.cpf();
        this.nome = clienteDTO.nome();
        this.dataNascimento = getDate(clienteDTO.dataNascimento());
        this.telefone = clienteDTO.telefone();
        this.endereco = new Endereco(clienteDTO.endereco());
    }

    //Função para atualizar os dados do Cliente
    public Cliente updateCliente(UpdateClienteDTO clienteDTO){
        this.nome = clienteDTO.nome();
        this.dataNascimento = getDate(clienteDTO.dataNascimento());
        this.telefone = clienteDTO.telefone();
        return this;
    }

    //Função para atualizar o Endereço
    public Cliente updateEndereco(CreateEnderecoDTO enderecoDTO){
        this.endereco = new Endereco(enderecoDTO);
        return this;
    }

    //Getters
    public String getCpf() {
        return cpf;
    }

    public int getClientId() {
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
    // de ID e CPF sejam considerados iguais
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
