package br.marcos.nesbusapi.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @NotBlank
    @Column(name = "bairro")
    private String bairro;

    @NotBlank
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Column(name = "estado")
    private String estado;

    @NotBlank
    @Column(name = "cep")
    private String cep;

}

