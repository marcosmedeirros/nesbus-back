package br.marcos.nesbusapi.model.viagem;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    Viagem findViagemByUuid(UUID uuid);

    List<Viagem> findByAtivaTrue();

    List<Viagem> findByDataViagemAfter(LocalDate data);

    @Query("SELECT v FROM Viagem v WHERE v.ativa = true AND v.dataViagem >= :dataInicio ORDER BY v.dataViagem ASC")
    List<Viagem> findViagensAtivas(LocalDate dataInicio);

    @Query("SELECT v FROM Viagem v WHERE v.motorista = :motorista AND v.ativa = true")
    List<Viagem> findByMotoristaAndAtivaTrue(String motorista);
}
