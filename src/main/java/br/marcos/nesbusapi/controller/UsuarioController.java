package br.marcos.nesbusapi.controller;

import br.marcos.nesbusapi.dto.usuario.UsuarioResponseDTO;
import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getUuid(),
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getTelefone(),
                        usuario.getDataNascimento(),
                        usuario.getEmail(),
                        usuario.getPermissao().getRole()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/perfil")
    public ResponseEntity<UsuarioResponseDTO> obterPerfil() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();

        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO(
                usuario.getUuid(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getDataNascimento(),
                usuario.getEmail(),
                usuario.getPermissao().getRole()
        );

        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UsuarioResponseDTO> obterUsuarioPorUuid(@PathVariable UUID uuid) {
        Usuario usuario = usuarioRepository.findUsuarioByUuid(uuid);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO(
                usuario.getUuid(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getDataNascimento(),
                usuario.getEmail(),
                usuario.getPermissao().getRole()
        );

        return ResponseEntity.ok(usuarioDTO);
    }
}

