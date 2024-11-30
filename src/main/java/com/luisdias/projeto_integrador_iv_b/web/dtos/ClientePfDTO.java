package com.luisdias.projeto_integrador_iv_b.web.dtos;

public record ClientePfDTO(
        Long clienteId,
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoDTO endereco
) {
}
