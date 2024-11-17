package com.luisdias.projeto_integrador_iv_b.model.entities;

import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.db.Identificador;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.model.Pessoa;

import java.util.Objects;

// A classe ClientePessoaFisica representa uma entidade a ser persistida no banco de dados
// e é uma especialização da classe Pessoa
public class ClientePessoaFisica extends Pessoa implements Identificador<Long> {
    // ID
    private long id;

    // Construtor padrão
    public ClientePessoaFisica(){
    }

    // Construtor que recebe um DTO
    public ClientePessoaFisica(PessoaCreateDTO clienteDTO){
        super(clienteDTO);
        this.id = generateId(clienteDTO.cpf());
    }

    // Método para atualizar os dados do Cliente
    public ClientePessoaFisica updateCliente(PessoaUpdateDTO pessoaUpdateDTO) {
        super.update(pessoaUpdateDTO);
        return this;
    }

    // Método para atualizar o Endereço do Cliente
    public ClientePessoaFisica newEndereco(EnderecoCreateDTO enderecoCreateDTO) {
        super.updateEndereco(enderecoCreateDTO);
        return this;
    }

    // Implementação do método exigido pelo banco de dados
    @Override
    public Long getId() {
        return id;
    }

    // Método auxiliar para geração do ID
    private long generateId(String id) {
        long aux = Objects.hash(id);
        return aux > 0 ? aux : aux * aux;
    }

    // Sobrescrevendo equals e hashCode para garantir que dois Clientes com os mesmos valores
    // de CPF sejam considerados iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePessoaFisica cliente = (ClientePessoaFisica) o;
        return id == cliente.id && Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCpf());
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Data de nascimento: " + getDataNascimento() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Endereco: " + "\n" +
                getEndereco();
    }
}
