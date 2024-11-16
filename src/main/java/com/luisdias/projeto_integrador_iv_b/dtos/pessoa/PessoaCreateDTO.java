package com.luisdias.projeto_integrador_iv_b.dtos.pessoa;

import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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
        String telefone,
        @Valid
        EnderecoCreateDTO endereco
) {
}
