package br.marcos.nesbusapi.model.solicitacao;



import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.viagemData.viagemData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "solicitacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "acompanhante")
    private boolean acompanhante;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "informacoes")
    private String informacoes;

    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<viagemData> viagemData;
}
