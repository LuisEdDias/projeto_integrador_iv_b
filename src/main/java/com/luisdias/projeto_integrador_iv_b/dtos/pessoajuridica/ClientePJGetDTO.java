package com.luisdias.projeto_integrador_iv_b.dtos.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaGetDTO;
import com.luisdias.projeto_integrador_iv_b.model.entities.ClientePessoaJuridica;

public record ClientePJGetDTO(
        String clienteId,
        EmpresaGetDTO empresa
) {
    public ClientePJGetDTO(ClientePessoaJuridica cliente) {
        this(
                cliente.getId(),
                new EmpresaGetDTO(cliente)
        );
    }
}
