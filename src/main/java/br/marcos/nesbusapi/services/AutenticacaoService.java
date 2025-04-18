package br.marcos.nesbusapi.services;


import br.marcos.nesbusapi.models.Usuario.Usuario;
import br.marcos.nesbusapi.models.Usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        Usuario usuario = this.repository.findByEmailUsuario(emailUsuario);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário ou senha errados!");
        } else {
            UserDetails user = User.withUsername(usuario.getEmailUsuario()).password(usuario.getSenhaUsuario())
                    .authorities(usuario.getPermissao()).build();
            return user;
        }
    }
}
