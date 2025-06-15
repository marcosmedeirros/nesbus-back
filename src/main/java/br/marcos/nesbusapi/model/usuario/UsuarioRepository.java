package br.marcos.nesbusapi.model.usuario;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);

    Usuario findUsuarioByEmail(String email);

    Usuario findUsuarioByUuid(UUID uuid);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
