package br.marcos.nesbusapi.model.usuario;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    public Usuario findUsuarioByUuid(UUID uuid);

}
