package br.marcos.nesbusapi.controller;



import br.marcos.nesbusapi.model.solicitacao.Solicitacao;
import br.marcos.nesbusapi.model.solicitacao.SolicitacaoDTO;
import br.marcos.nesbusapi.service.SolicitacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    private SolicitacaoService service;

    public SolicitacaoController(SolicitacaoService service) {
        this.service = service;
    }

    @PostMapping("/solicitacao")
    @Operation(summary = "Cria uma solicitacao", description = "Cadastra uma solicitacao com todas as regras de negócio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacao efetuada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Solicitacao.class))),
            @ApiResponse(responseCode = "404", description = "Solicitacao não caadstrada", content = @Content)
    })


    public void cadastrarCompra(@RequestBody SolicitacaoDTO compraDTO){
        this.service.cadastrarViagem(compraDTO);
    }


}
