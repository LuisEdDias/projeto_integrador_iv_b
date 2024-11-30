package com.luisdias.projeto_integrador_iv_b.api.dtos.clientepj;

import com.luisdias.projeto_integrador_iv_b.api.dtos.empresa.EmpresaGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.model.entities.ClientePessoaJuridica;

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
