package br.marcos.nesbusapi.controller;


import br.marcos.nesbusapi.model.viagem.Viagem;
import br.marcos.nesbusapi.service.ViagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    private ViagemService service;

    public ViagemController(ViagemService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    @Operation(summary = "Busca as viagens", description = "Retorna tosos as viagens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "viagem encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Viagem.class))),
            @ApiResponse(responseCode = "404", description = "viagens não encontradas", content = @Content)
    })
    public List<Viagem> listar(){
        return this.service.listar();
    }

    @PostMapping
    @Operation(summary = "Cria uma viagem", description = "Retorna uma viagem correspondente ao UUID criado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viagem cadastrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Viagem.class))),
            @ApiResponse(responseCode = "404", description = "Viagem não cadastrada", content = @Content)
    })
    public ResponseEntity salvar(@RequestBody @Valid Viagem produto, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(produto);
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        URI uri = uriComponentsBuilder.path("/viagem/uuid/{uuid}").buildAndExpand(produto.getUuid()).toUri();
        return ResponseEntity.created(uri).body(produto);

    }


    @Operation(summary = "Busca uma viagem", description = "Retorna uma viagem correspondente ao UUID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viagem encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Viagem.class))),
            @ApiResponse(responseCode = "404", description = "Viagem não encontradoa", content = @Content)
    })


    @GetMapping("/uuid/{uuid}")
    public Viagem viagem(@PathVariable String uuid){
        return this.service.getViagemUUID(uuid);
    }
}
