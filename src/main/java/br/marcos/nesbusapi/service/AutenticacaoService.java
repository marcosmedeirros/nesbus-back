package br.marcos.nesbusapi.service;


import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario usuario = this.repository.findByEmail(email);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario ou sneha inexistente");
        } else {
            UserDetails user = User.withUsername(usuario.getEmail()).password(usuario.getSenha()).authorities(usuario.getPermissao()).build();
            return user;
        }
    }

}
