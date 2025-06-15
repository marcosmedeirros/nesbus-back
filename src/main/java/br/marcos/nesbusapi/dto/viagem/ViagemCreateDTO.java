package br.marcos.nesbusapi.dto.viagem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViagemCreateDTO(
        @NotBlank String nome,
        @NotNull LocalDate dataViagem,
        @NotBlank String motorista,
        @Min(value = 1, message = "A quantidade de vagas deve ser maior que 0") int quantidadeVagas,
        String origem,
        String destino,
        String horarioSaida,
        String observacoes
) {}

