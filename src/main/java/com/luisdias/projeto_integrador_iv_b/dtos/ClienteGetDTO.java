package com.luisdias.projeto_integrador_iv_b.dtos;

import com.luisdias.projeto_integrador_iv_b.entities.Cliente;

public record ClienteGetDTO(
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoGetDTO endereco
) {
    public ClienteGetDTO(Cliente cliente) {
        this(
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getDataNascimento().toString(),
                cliente.getTelefone(),
                new EnderecoGetDTO(cliente.getEndereco())
        );
    }
}
