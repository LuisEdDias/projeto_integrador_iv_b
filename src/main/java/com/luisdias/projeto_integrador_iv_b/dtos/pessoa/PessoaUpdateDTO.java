package com.luisdias.projeto_integrador_iv_b.dtos.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PessoaUpdateDTO(
        @NotBlank(message = "Nome não deve estar em branco.")
        @Pattern(
                regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]{3,255}$",
                message = "Nome deve conter entre 3 e 255 caracteres, incluindo apenas letras, espaços, apóstrofes e hifens."
        )
        String nome,
        @NotBlank(message = "Data de nascimento não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{2}/\\d{2}/\\d{4}$",
                message = "Data de nascimento deve estar no formato dd/MM/yyyy."
        )
        String dataNascimento,
        @NotBlank(message = "Telefone não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{10,11}$",
                message = "Telefone deve conter 10 ou 11 dígitos."
        )
        String telefone
) {
}
