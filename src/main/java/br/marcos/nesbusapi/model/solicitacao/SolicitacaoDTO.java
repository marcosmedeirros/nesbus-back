package br.marcos.nesbusapi.model.solicitacao;

import br.marcos.nesbusapi.model.viagemData.viagemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class SolicitacaoDTO {

    private Long UsuarioId;
    private List<ViagemDataDTO> viagemData;


    public Long getUsuarioId() {
        return UsuarioId;
    }

    public List<ViagemDataDTO> getViagemData() {
        return viagemData;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ViagemDataDTO {
        private Long viagemId;
        private int quantidadevagas;
    }
}
