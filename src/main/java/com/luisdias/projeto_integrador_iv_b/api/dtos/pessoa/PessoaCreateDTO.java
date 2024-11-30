package com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record PessoaCreateDTO(
        @NotBlank(message = "CPF não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{11}$",
                message = "CPF deve conter exatamente 11 dígitos."
        )
        String cpf,
        @NotBlank(message = "Nome não deve estar em branco.")
        @Pattern(
                regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]{3,255}$",
                message = "Nome deve conter entre 3 e 255 caracteres, incluindo apenas letras e espaços."
        )
        String nome,
        @Past(message = "Data de nascimento inválida.")
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
        Date dataNascimento,
        @NotBlank(message = "Telefone não deve estar em branco.")
        @Pattern(
                regexp = "^\\d{10,11}$",
                message = "Telefone deve conter 10 ou 11 dígitos."
        )
        String telefone,
        @Valid
        EnderecoCreateDTO endereco
) {
}
