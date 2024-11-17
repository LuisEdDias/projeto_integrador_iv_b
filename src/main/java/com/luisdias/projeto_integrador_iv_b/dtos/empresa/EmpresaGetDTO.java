package com.luisdias.projeto_integrador_iv_b.dtos.empresa;

import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaGetDTO;
import com.luisdias.projeto_integrador_iv_b.model.Empresa;

public record EmpresaGetDTO(
        String razaoSocial,
        String cnpj,
        EnderecoGetDTO endereco,
        PessoaGetDTO proprietario
) {
    public EmpresaGetDTO(Empresa empresa) {
        this(
                empresa.getRazaoSocial(),
                empresa.getCnpj(),
                new EnderecoGetDTO(empresa.getEndereco()),
                new PessoaGetDTO(empresa.getProprietario())
        );
    }
}
