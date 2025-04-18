package br.marcos.nesbusapi.controllers;

import br.marcos.nesbusapi.infra.TokenService;
import br.marcos.nesbusapi.models.Usuario.Usuario;
import br.marcos.nesbusapi.models.Usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final AuthenticationManager manager;

    private final TokenService tokenServiceJWT;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenServiceJWT = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            Authentication autenticado = new UsernamePasswordAuthenticationToken(dados.emailUsuario(), dados.senhaUsuario());
            Authentication at = manager.authenticate(autenticado);
            User user = (User) at.getPrincipal();
            String token = this.tokenServiceJWT.gerarToken(user);
            return ResponseEntity.ok().body(new DadosTokenJWT(token));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid CadastrarUsuario data) {
        if(data.emailUsuario() == null || data.senhaUsuario() == null || data.permissao() == null)
            return ResponseEntity.badRequest().build();
            String sncriptPassword = new BCryptPasswordEncoder().encode(data.senhaUsuario());
            Usuario newUser = new Usuario(data.emailUsuario(), sncriptPassword, data.permissao());
            this.usuarioRepository.save(newUser);
            return ResponseEntity.ok().build();
    }

    private record DadosTokenJWT(String token) {
    }

    private record DadosAutenticacao(String emailUsuario, String senhaUsuario){

    }

    private record CadastrarUsuario(String emailUsuario, String senhaUsuario, String permissao){

    }
}
