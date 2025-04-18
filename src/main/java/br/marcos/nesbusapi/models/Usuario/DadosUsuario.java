package br.marcos.nesbusapi.models.Usuario;

import java.util.UUID;

public record DadosUsuario(String nomeUsuario ,String emailUsuario, String permissao) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getPermissao());
    }
}
