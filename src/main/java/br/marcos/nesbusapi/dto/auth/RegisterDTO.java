package br.marcos.nesbusapi.dto.auth;


import br.marcos.nesbusapi.model.usuario.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
        @NotBlank String nome,
        @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres") String cpf,
        String telefone,
        String dataNascimento,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres") String senha,
        UsuarioRole permissao,
        EnderecoDTO endereco
) {}