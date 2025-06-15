package br.marcos.nesbusapi.controller;

import br.marcos.nesbusapi.dto.auth.*;
import br.marcos.nesbusapi.infra.security.TokenServiceJWT;
import br.marcos.nesbusapi.model.Endereco;
import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.usuario.UsuarioRepository;
import br.marcos.nesbusapi.model.usuario.UsuarioRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenServiceJWT tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var usuario = (Usuario) auth.getPrincipal();
            var token = tokenService.generateToken(usuario.getEmail());

            return ResponseEntity.ok(new LoginResponseDTO(
                    token,
                    usuario.getUuid(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getPermissao().getRole()
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Credenciais inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.existsByEmail(data.email())) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        if (this.repository.existsByCpf(data.cpf())) {
            return ResponseEntity.badRequest().body("CPF já cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Endereco endereco = null;
        if (data.endereco() != null) {
            endereco = new Endereco();
            endereco.setLogradouro(data.endereco().logradouro());
            endereco.setNumero(data.endereco().numero());
            endereco.setComplemento(data.endereco().complemento());
            endereco.setBairro(data.endereco().bairro());
            endereco.setCidade(data.endereco().cidade());
            endereco.setEstado(data.endereco().estado());
            endereco.setCep(data.endereco().cep());
        }

        Usuario newUser = new Usuario(
                data.nome(),
                data.cpf(),
                data.telefone(),
                data.dataNascimento(),
                data.email(),
                encryptedPassword,
                data.permissao() != null ? data.permissao() : UsuarioRole.USER,
                endereco
        );

        this.repository.save(newUser);

        return ResponseEntity.ok().body("Usuário cadastrado com sucesso");
    }
}

