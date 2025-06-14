package br.marcos.nesbusapi.model.viagem;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "viagem")
@Getter
@Setter
@ToString
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "data_viagem", nullable = false)
    private Date dataviagem;

    @Column(name = "motorista")
    private String motorista;

    @Column(name = "quantidade_vagas")
    @Min(value = 1, message = "A quantidade deve ser maior que 0")
    private int quantidadevagas;

}
