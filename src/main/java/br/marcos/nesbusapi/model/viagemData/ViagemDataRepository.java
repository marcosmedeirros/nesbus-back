package br.marcos.nesbusapi.model.viagemData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ViagemDataRepository extends JpaRepository<viagemData,Long> {

    @Query(value = "SELECT fk_id_solicitacao, quantidade_vagas FROM viagemdata WHERE fk_id_viagem = :id", nativeQuery = true)
    List<viagemDataDTO> buscarViagem(@Param("id") Long id);
}
