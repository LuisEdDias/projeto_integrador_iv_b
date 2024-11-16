package com.luisdias.projeto_integrador_iv_b.dtos;

import com.luisdias.projeto_integrador_iv_b.entities.Cliente;

import java.text.SimpleDateFormat;

public record ClienteGetDTO(
        long clienteId,
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoGetDTO endereco
) {
    public ClienteGetDTO(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                new SimpleDateFormat("dd-MM-yyyy").format(cliente.getDataNascimento()),
                cliente.getTelefone(),
                new EnderecoGetDTO(cliente.getEndereco())
        );
    }
}
