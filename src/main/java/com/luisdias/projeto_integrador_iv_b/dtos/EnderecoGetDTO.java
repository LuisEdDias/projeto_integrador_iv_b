package com.luisdias.projeto_integrador_iv_b.dtos;

import com.luisdias.projeto_integrador_iv_b.entities.Endereco;

public record EnderecoGetDTO(
        String rua,
        String numero,
        String cep,
        String bairro,
        String cidade,
        String estado,
        String complemento
) {
        public EnderecoGetDTO(Endereco endereco) {
                this(
                        endereco.getRua(),
                        endereco.getNumero(),
                        endereco.getCep(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getComplemento()
                );
        }
}
