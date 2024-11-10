package com.luisdias.projeto_integrador_iv_b.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreateEnderecoDTO(
        @NotBlank(message = "Rua não deve estar em branco.")
        @Length(
                min = 3, max = 255,
                message = "Rua deve conter entre 3 e 255 caracteres."
        )
        String rua,
        @NotBlank(message = "Número não deve estar em branco.")
        @Length(
                max = 10,
                message = "Número deve conter no máximo 10 caracteres."
        )
        String numero,
        @NotBlank(message = "CEP não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{8}$",
                message = "CEP deve conter exatamente 8 dígitos."
        )
        String cep,
        @NotBlank(message = "Bairro não deve estar em branco.")
        @Length(
                min = 3, max = 255,
                message = "Rua deve conter entre 3 e 255 caracteres."
        )
        String bairro,
        @NotBlank(message = "Cidade não deve estar em branco.")
        @Length(
                min = 3, max = 255,
                message = "Rua deve conter entre 3 e 255 caracteres."
        )
        String cidade,
        @NotBlank(message = "Estado não deve estar em branco.")
        @Pattern(
                regexp = "^\\[A-Z]{2}$",
                message = "Estado deve ser representado por 2 letras maiúsculas."
        )
        String estado,
        @Length(
                max = 255,
                message = "Complemento deve conter no máximo 255 caracteres."
        )
        String complemento
) {
}
