package com.luisdias.projeto_integrador_iv_b.entities;

import com.luisdias.projeto_integrador_iv_b.dtos.EnderecoCreateDTO;

import java.util.Objects;

// Classe utiliza o padrão Value Object(VO) por apresentar as seguintes caracteristicas:
// Imutabilidade: Endereços são criados uma vez e, se mudarem, devem gerar um novo objeto.
// Igualdade por Valor: Endereços com os mesmos valores são considerados iguais, independentemente de
// serem instâncias diferentes.
// Dependência: Endereços não têm identidade própria e são atributos de outras entidades.
public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;

    // Construtor usado pelo banco de dados
    public Endereco(){}

    // Construtor que recebe um DTO
    public Endereco(EnderecoCreateDTO enderecoDTO) {
        this.rua = enderecoDTO.rua();
        this.numero = enderecoDTO.numero();
        this.cep = enderecoDTO.cep();
        this.bairro = enderecoDTO.bairro();
        this.cidade = enderecoDTO.cidade();
        this.estado = enderecoDTO.estado();
        this.complemento = enderecoDTO.complemento();
    }

    // Getters
    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    // Sobrescrevendo equals e hashCode para garantir que dois Enderecos com os mesmos valores sejam considerados iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        return rua.equals(endereco.rua) &&
                numero.equals(endereco.numero) &&
                cep.equals(endereco.cep) &&
                bairro.equals(endereco.bairro) &&
                cidade.equals(endereco.cidade) &&
                estado.equals(endereco.estado) &&
                (Objects.equals(complemento, endereco.complemento));
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, numero, cep, bairro, cidade, estado, complemento);
    }

    @Override
    public String toString() {
        return rua + " " +
                numero +
                (complemento.isEmpty()? "\n" : (", " + complemento + "\n ")) +
                bairro + "\n" +
                String.format("%s-%s", cep.substring(0,5), cep.substring(5,8)) + " " +
                cidade + "/" +
                estado;
    }
}
