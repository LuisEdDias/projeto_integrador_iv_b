package com.luisdias.projeto_integrador_iv_b.dtos.cliente.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoGetDTO;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaFisica;

import java.text.SimpleDateFormat;

public record ClientePFGetDTO(
        long clienteId,
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoGetDTO endereco
) {
    public ClientePFGetDTO(ClientePessoaFisica cliente) {
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
