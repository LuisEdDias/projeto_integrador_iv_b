package com.luisdias.projeto_integrador_iv_b.api.model.entities;

import com.luisdias.projeto_integrador_iv_b.api.model.sgbd.Identificador;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.Pessoa;

import java.util.Objects;

/**
 * A classe ClientePessoaFisica representa uma entidade a ser persistida no banco de dados
 * e é uma especialização da classe Pessoa.
 */
public class ClientePessoaFisica extends Pessoa implements Identificador<Long> {
    // ID
    private long id;

    // Construtor padrão
    public ClientePessoaFisica() {
    }

    /**
     * Construtor que recebe um DTO.
     *
     * @param clienteDTO DTO com os dados para criação de um cliente.
     */
    public ClientePessoaFisica(PessoaCreateDTO clienteDTO) {
        super(clienteDTO);
        this.id = generateId(clienteDTO.cpf());
    }

    /**
     * Método para atualizar o Endereço do Cliente.
     *
     * @param updateDTO DTO com os dados para atualizar os dados do cliente.
     * @return O objeto ClientePessoaFisica atualizado.
     */
    public ClientePessoaFisica updateCliente(PessoaUpdateDTO updateDTO) {
        super.update(updateDTO);
        return this;
    }

    /**
     * Método para atualizar o Endereço do Cliente.
     *
     * @param createDTO DTO com os dados para atualizar o endereço.
     * @return O objeto ClientePessoaFisica atualizado.
     */
    public ClientePessoaFisica newEndereco(EnderecoCreateDTO createDTO) {
        super.updateEndereco(createDTO);
        return this;
    }

    // Implementação do método exigido pelo banco de dados.
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Método auxiliar para geração do ID através do hash de uma String.
     *
     * @param id String de entrada.
     * @return Long.
     */
    private long generateId(String id) {
        long aux = Objects.hash(id);
        return aux > 0 ? aux : aux * aux;
    }

    /**
     * Sobrescrevendo equals para garantir que dois Clientes com os mesmos valores
     * de CPF sejam considerados iguais.
     *
     * @param o Root Class Object.
     * @return True caso os dois objetos sejam considerados iguais.
     */
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
