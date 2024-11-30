package com.luisdias.projeto_integrador_iv_b.api.dtos.empresa;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.Empresa;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaGetDTO;

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
