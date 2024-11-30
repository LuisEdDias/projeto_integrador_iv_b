package com.luisdias.projeto_integrador_iv_b.api.dtos.clientepf;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaFisica;

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
                new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDataNascimento()),
                cliente.getTelefone(),
                new EnderecoGetDTO(cliente.getEndereco())
        );
    }
}
