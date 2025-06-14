package br.marcos.nesbusapi.model.usuario;


public record DadosUsuario(Long id, String email, String nome, String cpf, String permissao) {
    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getNome(), usuario.getCpf(), usuario.getPermissao());
    }
}
