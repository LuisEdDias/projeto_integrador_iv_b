package com.luisdias.projeto_integrador_iv_b.web.dtos;

public record PessoaDTO(
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoDTO endereco
) {
}
