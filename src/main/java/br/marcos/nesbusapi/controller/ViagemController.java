package br.marcos.nesbusapi.controller;

import br.marcos.nesbusapi.dto.viagem.ViagemCreateDTO;
import br.marcos.nesbusapi.dto.viagem.ViagemResponseDTO;
import br.marcos.nesbusapi.model.viagem.Viagem;
import br.marcos.nesbusapi.model.viagem.ViagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("viagem")
@CrossOrigin(origins = "*")
public class ViagemController {

    @Autowired
    private ViagemRepository viagemRepository;

    @PostMapping
    public ResponseEntity<ViagemResponseDTO> criarViagem(@RequestBody @Valid ViagemCreateDTO data) {
        Viagem viagem = new Viagem(
                data.nome(),
                data.dataViagem(),
                data.motorista(),
                data.quantidadeVagas(),
                data.origem(),
                data.destino(),
                data.horarioSaida(),
                data.observacoes()
        );

        Viagem viagemSalva = viagemRepository.save(viagem);

        ViagemResponseDTO response = new ViagemResponseDTO(
                viagemSalva.getUuid(),
                viagemSalva.getNome(),
                viagemSalva.getDataViagem(),
                viagemSalva.getMotorista(),
                viagemSalva.getQuantidadeVagas(),
                viagemSalva.getOrigem(),
                viagemSalva.getDestino(),
                viagemSalva.getHorarioSaida(),
                viagemSalva.getObservacoes(),
                viagemSalva.isAtiva()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ViagemResponseDTO>> listarViagens() {
        List<Viagem> viagens = viagemRepository.findViagensAtivas(LocalDate.now());
        List<ViagemResponseDTO> viagensDTO = viagens.stream()
                .map(viagem -> new ViagemResponseDTO(
                        viagem.getUuid(),
                        viagem.getNome(),
                        viagem.getDataViagem(),
                        viagem.getMotorista(),
                        viagem.getQuantidadeVagas(),
                        viagem.getOrigem(),
                        viagem.getDestino(),
                        viagem.getHorarioSaida(),
                        viagem.getObservacoes(),
                        viagem.isAtiva()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(viagensDTO);
    }

    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<ViagemResponseDTO> obterViagemPorUuid(@PathVariable UUID uuid) {
        Viagem viagem = viagemRepository.findViagemByUuid(uuid);

        if (viagem == null) {
            return ResponseEntity.notFound().build();
        }

        ViagemResponseDTO response = new ViagemResponseDTO(
                viagem.getUuid(),
                viagem.getNome(),
                viagem.getDataViagem(),
                viagem.getMotorista(),
                viagem.getQuantidadeVagas(),
                viagem.getOrigem(),
                viagem.getDestino(),
                viagem.getHorarioSaida(),
                viagem.getObservacoes(),
                viagem.isAtiva()
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ViagemResponseDTO> atualizarViagem(@PathVariable UUID uuid,
                                                             @RequestBody @Valid ViagemCreateDTO data) {
        Viagem viagem = viagemRepository.findViagemByUuid(uuid);

        if (viagem == null) {
            return ResponseEntity.notFound().build();
        }

        viagem.setNome(data.nome());
        viagem.setDataViagem(data.dataViagem());
        viagem.setMotorista(data.motorista());
        viagem.setQuantidadeVagas(data.quantidadeVagas());
        viagem.setOrigem(data.origem());
        viagem.setDestino(data.destino());
        viagem.setHorarioSaida(data.horarioSaida());
        viagem.setObservacoes(data.observacoes());

        Viagem viagemAtualizada = viagemRepository.save(viagem);

        ViagemResponseDTO response = new ViagemResponseDTO(
                viagemAtualizada.getUuid(),
                viagemAtualizada.getNome(),
                viagemAtualizada.getDataViagem(),
                viagemAtualizada.getMotorista(),
                viagemAtualizada.getQuantidadeVagas(),
                viagemAtualizada.getOrigem(),
                viagemAtualizada.getDestino(),
                viagemAtualizada.getHorarioSaida(),
                viagemAtualizada.getObservacoes(),
                viagemAtualizada.isAtiva()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> desativarViagem(@PathVariable UUID uuid) {
        Viagem viagem = viagemRepository.findViagemByUuid(uuid);

        if (viagem == null) {
            return ResponseEntity.notFound().build();
        }

        viagem.setAtiva(false);
        viagemRepository.save(viagem);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/motorista/{motorista}")
    public ResponseEntity<List<ViagemResponseDTO>> listarViagensPorMotorista(@PathVariable String motorista) {
        List<Viagem> viagens = viagemRepository.findByMotoristaAndAtivaTrue(motorista);
        List<ViagemResponseDTO> viagensDTO = viagens.stream()
                .map(viagem -> new ViagemResponseDTO(
                        viagem.getUuid(),
                        viagem.getNome(),
                        viagem.getDataViagem(),
                        viagem.getMotorista(),
                        viagem.getQuantidadeVagas(),
                        viagem.getOrigem(),
                        viagem.getDestino(),
                        viagem.getHorarioSaida(),
                        viagem.getObservacoes(),
                        viagem.isAtiva()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(viagensDTO);
    }
}

