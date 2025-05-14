package br.marcos.nesbusapi.model.viagemData;


import br.marcos.nesbusapi.model.viagem.Viagem;
import br.marcos.nesbusapi.model.solicitacao.Solicitacao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "viagem_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class viagemData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "fk_id_solicitacao", nullable = false)
    private Viagem solicitacao;

    @ManyToOne
    @JoinColumn(name = "fk_id_viagem", nullable = false)
    private Solicitacao viagem;

    @Column(name = "vagas_ocupadas", nullable = false)
    private int vagasocupadas;

    @Column(name = "quantidadevagas", nullable = false)
    private int quantidadeVagas;


}
