package com.luisdias.projeto_integrador_iv_b.web.dtos;

public record EmpresaDTO(String cnpj, String razaoSocial, EnderecoDTO endereco,PessoaDTO proprietario) {
}
