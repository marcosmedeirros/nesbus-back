package br.marcos.nesbusapi.controller;


import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.usuario.DadosUsuario;
import br.marcos.nesbusapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }



    @PostMapping
    @Operation(summary = "Cria um usuario", description = "Cadastra um usuario novo - jah deve vir com o endereco junto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario cadastrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "404", description = "Usuario não cadastrado", content = @Content)
    })
    public ResponseEntity salvar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        this.service.salvar(usuario);
        URI uri = uriComponentsBuilder.path("/usuario/uuid/{uuid}").buildAndExpand(usuario.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new DadosUsuario(usuario));
    }

    @GetMapping("/uuid/{uuid}")
    public DadosUsuario cliente(@PathVariable String uuid){
        return this.service.getClienteUUID(uuid);
    }

    @GetMapping("/listar")
    @Operation(summary = "lista os usuario", description = "Vai trazer todos os usuario cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuario encotrados",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "404", description = "usuario não encontrados", content = @Content)
    })
    public List<DadosUsuario> listar(){
        return this.service.listar();

    }
}
