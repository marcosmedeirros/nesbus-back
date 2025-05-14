package br.marcos.nesbusapi.model.viagem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    public Viagem findViagemByUuid(UUID uuid);
}
