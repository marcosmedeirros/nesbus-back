package br.marcos.nesbusapi.model.viagemData;

public class viagemDataDTO {

    private Long fk_id_solicitacao;
    private int quantidadevagas;

    // Construtor
    public viagemDataDTO(Long fk_id_produto, int quantidadevagas) {
        this.fk_id_solicitacao = fk_id_solicitacao;
        this.quantidadevagas = quantidadevagas;
    }

    // Getter correto para 'ViagemId'
    public Long getViagemId() {
        return fk_id_solicitacao;
    }

    public void setSolicitacaoId(Long fk_id_solicitacao) {
        this.fk_id_solicitacao = fk_id_solicitacao;
    }

    // Getter correto para 'quantidadevagas'
    public float getQuantidaDeVagas() {
        return quantidadevagas;
    }

    public void setquantidaDeVagas(int quantidadevagas) {
        this.quantidadevagas = quantidadevagas;
    }

}
