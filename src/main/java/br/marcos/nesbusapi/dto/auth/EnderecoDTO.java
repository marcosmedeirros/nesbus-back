package br.marcos.nesbusapi.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
        @NotBlank String logradouro,
        @NotBlank String numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String estado,
        @NotBlank String cep
) {}


