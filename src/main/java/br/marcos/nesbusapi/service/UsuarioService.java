package br.marcos.nesbusapi.service;


import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.usuario.UsuarioRepository;
import br.marcos.nesbusapi.model.usuario.DadosUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.repository.save(usuario);
    }

    public List<DadosUsuario> listar(){
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }

    public DadosUsuario getClienteUUID(String uuid) {
        UUID uuidformatado = UUID.fromString(uuid);
        Usuario usuario = this.repository.findUsuarioByUuid(uuidformatado);
        if (usuario == null) {
            return null;
        }
        return new DadosUsuario(usuario);
    }


}
