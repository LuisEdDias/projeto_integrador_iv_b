package com.luisdias.projeto_integrador_iv_b.model.entities;

import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.infra.db.Identificador;
import com.luisdias.projeto_integrador_iv_b.model.Empresa;

import java.util.Objects;

// A classe ClientePessoaJuridica representa uma entidade a ser persistida no banco de dados
// e é uma especialização da classe Empresa
public class ClientePessoaJuridica extends Empresa implements Identificador<String> {
    // ID
    private String id;

    // Construtor padrão
    public ClientePessoaJuridica() {}

    // Construtor que recebe um DTO
    public ClientePessoaJuridica(EmpresaCreateDTO empresaCreateDTO) {
        super(empresaCreateDTO);
        this.id = empresaCreateDTO.cnpj();
    }

    // Método que atualiza o Endereço da Empresa
    public ClientePessoaJuridica updateEndereco(EnderecoCreateDTO enderecoCreateDTO) {
        super.setEndereco(enderecoCreateDTO);
        return this;
    }

    // Método que atualiza o Endereço do Proprietário
    public ClientePessoaJuridica updateEnderecoProprietario(EnderecoCreateDTO enderecoCreateDTO) {
        super.setEnderecoProprietario(enderecoCreateDTO);
        return this;
    }

    // Método que atualiza os dados do Proprietário
    public ClientePessoaJuridica updateDadosProprietario(PessoaUpdateDTO updateDTO) {
        super.updateProprietario(updateDTO);
        return this;
    }

    // Método que troca o Proprietário da Empresa
    public ClientePessoaJuridica updateProprietario(PessoaCreateDTO proprietarioCreateDTO) {
        super.setProprietario(proprietarioCreateDTO);
        return this;
    }

    // Implementação do método exigido pelo banco de dados
    @Override
    public String getId() {
        return id;
    }

    // Sobrescrevendo equals e hashCode para garantir que dois Clientes com os mesmos valores
    // de CNPJ sejam considerados iguais
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
