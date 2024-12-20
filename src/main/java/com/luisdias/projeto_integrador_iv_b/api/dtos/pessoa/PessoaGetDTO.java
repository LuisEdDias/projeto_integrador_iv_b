package com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.Pessoa;

import java.text.SimpleDateFormat;

public record PessoaGetDTO(
        String cpf,
        String nome,
        String dataNascimento,
        String telefone,
        EnderecoGetDTO endereco
) {
    public PessoaGetDTO(Pessoa pessoa) {
        this(
                pessoa.getCpf(),
                pessoa.getNome(),
                new SimpleDateFormat("yyyy-MM-dd").format(pessoa.getDataNascimento()),
                pessoa.getTelefone(),
                new EnderecoGetDTO(pessoa.getEndereco())
        );
    }
}
