package br.marcos.nesbusapi.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuariooByUuid(UUID uuid);
    public void deletePacienteByUuid(UUID uuid);


    public Usuario findByEmailUsuario (String emailUsuario);

}

