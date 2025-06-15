package br.marcos.nesbusapi.dto.auth;

import java.util.UUID;

public record LoginResponseDTO(
        String token,
        UUID uuid,
        String nome,
        String email,
        String permissao
) {}
