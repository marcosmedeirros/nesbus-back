package br.marcos.nesbusapi.model.viagem;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "data_viagem")
    private LocalDate dataViagem;

    @NotBlank
    @Column(name = "motorista")
    private String motorista;

    @Min(value = 1, message = "A quantidade de vagas deve ser maior que 0")
    @Column(name = "quantidade_vagas")
    private int quantidadeVagas;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

    @Column(name = "horario_saida")
    private String horarioSaida;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "ativa")
    private boolean ativa = true;

    // Construtor para criação de viagem
    public Viagem(String nome, LocalDate dataViagem, String motorista, int quantidadeVagas,
                  String origem, String destino, String horarioSaida, String observacoes) {
        this.nome = nome;
        this.dataViagem = dataViagem;
        this.motorista = motorista;
        this.quantidadeVagas = quantidadeVagas;
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.observacoes = observacoes;
        this.ativa = true;
    }
}

