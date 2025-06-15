package br.marcos.nesbusapi.dto.viagem;

import java.time.LocalDate;
import java.util.UUID;

public record ViagemResponseDTO(
        UUID uuid,
        String nome,
        LocalDate dataViagem,
        String motorista,
        int quantidadeVagas,
        String origem,
        String destino,
        String horarioSaida,
        String observacoes,
        boolean ativa
) {}

