package br.marcos.nesbusapi.controllers;


import br.marcos.nesbusapi.models.Usuario.DadosUsuario;
import br.marcos.nesbusapi.models.Usuario.Usuario;
import br.marcos.nesbusapi.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuarios", description = "API para gerenciamento de usuarios")
public class UsuarioController{
    private UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }



    @GetMapping("/listar")
    @Operation(summary = "listar Usuario",
            description = "Lista todos os Usuario cadastrados no banco de dados")
    public List<DadosUsuario> findAll(){
        return this.service.findAllUsuarios();
    }


    @PostMapping("/add")
    @Transactional
    @Operation(summary = "Adiciona Usuario",
            description = "Adiciona um Usuario no banco de dados")
    public ResponseEntity salvar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        this.service.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{uuid}").buildAndExpand(usuario.getIdusuario()).toUri();
        String mensagem = "Usuario adicionado com sucesso!";
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        resposta.put("usuario", usuario);
        return ResponseEntity.created(uri).body(usuario);
    }


    @GetMapping("/buscar/{uuid}")
    @Operation(summary = "Buscar UM Usuario por UUID",
            description = "Busca um Usuario no banco de dados por UUID")
    public DadosUsuario dadosUsuario (@PathVariable String uuid){
        return this.service.findUsuario(UUID.fromString(uuid));
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar Usuario por UUID",
            description = "Atualiza um Usuario no banco de dados por UUID")
    public ResponseEntity atualizarUUID(@RequestBody @Valid Usuario usuario){
        this.service.AtualizarUUID(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletar/{uuid}")
    @Operation(summary = "Deletar Usuario por UUID",
            description = "Deleta um Usuario no banco de dados por UUID")
    public ResponseEntity deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
        return ResponseEntity.noContent().build();
    }

}


