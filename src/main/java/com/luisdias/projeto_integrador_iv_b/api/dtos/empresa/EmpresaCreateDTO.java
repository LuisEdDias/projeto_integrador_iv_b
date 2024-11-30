package com.luisdias.projeto_integrador_iv_b.api.dtos.empresa;

import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaCreateDTO(
        @NotBlank(message = "Razão social não deve estar em branco.")
        @Pattern(
                regexp = "^[0-9A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]{3,255}$",
                message = "Razão social deve conter entre 3 e 255 caracteres, incluindo apenas letras, espaços e números."
        )
        String razaoSocial,
        @NotBlank(message = "CNPJ não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{14}$",
                message = "CNPJ deve conter exatamente 14 dígitos."
        )
        String cnpj,
        @Valid
        EnderecoCreateDTO endereco,
        @Valid
        PessoaCreateDTO proprietario
) {
}
