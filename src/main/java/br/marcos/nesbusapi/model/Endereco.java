package br.marcos.nesbusapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
@Entity
@ToString
public class Endereco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @NotBlank
    @Column(name = "cep")
    private String cep;

    @NotBlank
    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private int numero;

    @NotBlank
    @Column(name = "bairro")
    private String bairro;

    @NotBlank
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Column(name = "estado")
    private String estado;



}
