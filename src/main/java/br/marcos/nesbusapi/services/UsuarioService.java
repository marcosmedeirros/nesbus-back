package br.marcos.nesbusapi.services;



import br.marcos.nesbusapi.models.Usuario.DadosUsuario;
import br.marcos.nesbusapi.models.Usuario.Usuario;
import br.marcos.nesbusapi.models.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;



@Service
public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Usuario usuario){
        usuario.setSenhaUsuario(new BCryptPasswordEncoder()
                .encode(usuario.getSenhaUsuario()));
        this.repository.save(usuario);
    }

    public List<Usuario> Listar(){
        return this.repository.findAll();
    }


    public void AtualizarUUID(Usuario usuario){
        Usuario u = this.repository.findUsuariooByUuid(usuario.getUuid());
        u.setNomeUsuario(usuario.getNomeUsuario());
        u.setEmailUsuario(usuario.getEmailUsuario());
        u.setSenhaUsuario(usuario.getSenhaUsuario());
        this.repository.save(u);
    }

    public Usuario getUsuarioByUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findUsuariooByUuid(uuidformatado);
    }

    @Transactional
    public void deletarUUID(String uuid){
        this.repository.deletePacienteByUuid(UUID.fromString(uuid));
    }


    public DadosUsuario findUsuario(UUID uuid){
        return new DadosUsuario(this.getUsuarioByUUID(uuid.toString()));
    }

    public List<DadosUsuario> findAllUsuarios(){
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }

}

