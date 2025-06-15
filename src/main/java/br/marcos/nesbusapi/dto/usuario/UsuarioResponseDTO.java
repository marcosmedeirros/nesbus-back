package br.marcos.nesbusapi.dto.usuario;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID uuid,
        String nome,
        String cpf,
        String telefone,
        String dataNascimento,
        String email,
        String permissao
) {}
