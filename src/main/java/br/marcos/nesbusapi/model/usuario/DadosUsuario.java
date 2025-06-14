package br.marcos.nesbusapi.model.usuario;


public record DadosUsuario(Long id, String email, String nome, String cpf, String dataNascimento, String telefone, String permissao) {
    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getNome(), usuario.getCpf(), usuario.getDataNascimento(),usuario.getTelefone(), usuario.getPermissao());
    }
}
