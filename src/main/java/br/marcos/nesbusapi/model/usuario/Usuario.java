package br.marcos.nesbusapi.model.usuario;


import br.marcos.nesbusapi.model.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Size(max = 14, min = 11, message = "CPF deve ter entre 11 e 14 caracteres")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(name = "senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "permissao")
    private UsuarioRole permissao = UsuarioRole.USER;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_endereco")
    private Endereco endereco;

    // Construtor para criação de usuário
    public Usuario(String nome, String cpf, String telefone, String dataNascimento,
                   String email, String senha, UsuarioRole permissao, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
        this.endereco = endereco;
    }

    // Implementação do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.permissao == UsuarioRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

