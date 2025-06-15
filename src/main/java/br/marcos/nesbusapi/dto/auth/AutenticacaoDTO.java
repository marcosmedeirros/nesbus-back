package br.marcos.nesbusapi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(
        @NotBlank @Email String email,
        @NotBlank String senha
) {}

